package org.example.config;

import lombok.Data;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;

@Data
@EnableRabbit
@Configuration
@ConfigurationProperties("rabbit")
public class RabbitConfig {

    private String host;
    private String port;
    private String username;
    private String password;
    private String vHost;
    private String exchangeName;
    private String trustStoreLocation;
    private String trustStorePass;
    private String keyStoreLocation;
    private String keyStorePass;
    private boolean neededSsl;

    @Bean
    public ConnectionFactory factory() throws Exception {
        CachingConnectionFactory factory = new CachingConnectionFactory();
        factory.setHost(host);
        factory.setVirtualHost(vHost);
        factory.setPort(Integer.parseInt(port));
        factory.setUsername(username);
        factory.setPassword(password);
        if (neededSsl) {
            initSSL(factory);
        }
        return factory;
    }

    private void initSSL(CachingConnectionFactory factory) throws Exception {
        String sslKeystoreLocation = keyStoreLocation;
        String sslKeyPassword = keyStorePass;
        String sslTrustStorePassword = trustStorePass;
        String sslTrustStoreLocation = trustStoreLocation;
        if (sslKeyPassword == null || sslKeystoreLocation == null || sslTrustStoreLocation == null || sslTrustStorePassword == null) {
            return;
        }
        SSLContext sslContext = getSslContext(sslKeystoreLocation, sslKeyPassword, sslTrustStorePassword);
        factory.getRabbitConnectionFactory().useSslProtocol(sslContext);
    }

    public static SSLContext getSslContext(String sslKeystoreLocation, String sslKeyPassword, String sslTrustStorePassword) throws GeneralSecurityException, IOException {
        char[] trustPassphrase = sslTrustStorePassword.toCharArray();
        KeyStore tks = KeyStore.getInstance("JKS");
        tks.load(new FileInputStream(System.getProperty("javax.net.ssl.trustStore")), trustPassphrase);

        TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
        tmf.init(tks);

        char[] keyPassphrase = sslKeyPassword.toCharArray();
        KeyStore ks = KeyStore.getInstance("PKCS12");
        ks.load(new FileInputStream(sslKeystoreLocation), keyPassphrase);

        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
        kmf.init(ks, keyPassphrase);

        final SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
        sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), new java.security.SecureRandom());
        return sslContext;
    }

    @Bean
    public AmqpAdmin amqpAdmin() throws Exception {
        return new RabbitAdmin(factory());
    }

    @Bean
    public RabbitTemplate rabbitTemplate() throws Exception {
        RabbitTemplate template = new RabbitTemplate(factory());
        template.setExchange(exchangeName);
        return template;
    }
}
