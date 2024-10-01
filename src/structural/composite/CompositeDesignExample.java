package structural.composite;

import java.util.ArrayList;
import java.util.List;

interface Filesystem{
    public void openFile();
};

class Directory implements Filesystem{

    List<Filesystem> filesystems;

    Directory(){
        filesystems = new ArrayList<>();
    }

    public void addFile(Filesystem file){
        filesystems.add(file);
    }

    @Override
    public void openFile() {
        for(Filesystem x:filesystems){
            x.openFile();
        }
    }
};

class File implements Filesystem{
    @Override
    public void openFile() {
        System.out.println("File System ended to file" + this);
    }
};

public class CompositeDesignExample {
    public static void main(String[] args) {
        Directory filesystem = new Directory();
        Directory filesytem1 = new Directory();
        filesytem1.addFile(new File());
        filesytem1.addFile(new File());
        filesystem.addFile(filesytem1);
        filesystem.addFile(new File());
        filesystem.addFile(new File());
        filesystem.addFile(new File());
        filesystem.openFile();
    }
}
