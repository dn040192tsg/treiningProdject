package dao;

import java.util.List;

public interface DirectoryDAO<DTO> {

    List<DTO> getDirectory();

    void putDirectory(List<DTO> directory);
}
