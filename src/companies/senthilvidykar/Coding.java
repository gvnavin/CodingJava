package companies.senthilvidykar;

import java.util.*;

public class Coding {

    /**
     *
     * we have a system that stores files, and these files can be grouped into collections. We are interested in knowing where our resources are being taken up.
     * For this system we would like to generate a report that lists:
     * The total size of all files stored; and
     * The top N collections (by file size) where N can be a user-defined value
     *
     *
     * file1.txt (size: 200) in collection "collection1"
     *
     * file2.txt (size: 200) in collection "collection1"
     *
     * file3.txt (size: 300) in collection "collection2"
     *
     *
     *
     *
     *
     */

    static class Collection {
        String name;
        long totalSize;

        public Collection(String name, long totalSize) {
            this.name = name;
            this.totalSize = totalSize;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Main.Pair) {
                Collection other = (Collection) obj;
                return this.name == other.name;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return (""+this.name).hashCode();
        }

        @Override
        public String toString() {
            return ""+this.name+","+this.totalSize;
        }
    }

    class FileSystem {
        Map<String, Long> collectionSizeMap;
        Map<String, Long> fileSizeMap;
        TreeMap<Long, Set<String>> sizeToCollectionList;
        long totalSize;

        public FileSystem() {
            this.fileSizeMap = new HashMap<>();
            this.collectionSizeMap = new HashMap<>();
            this.sizeToCollectionList = new TreeMap<Long, Set<String>>();
            this.totalSize = 0;
        }

        public void addFile(String fileName, int fileSize, String collection) {
            long currentFileSize = fileSizeMap.getOrDefault(fileName, 0l);
            if(currentFileSize != 0) {
                fileSize -= currentFileSize;
            }
            this.totalSize += fileSize;
            Long currentSize = collectionSizeMap.getOrDefault(collection, 0l);
            if(currentSize != 0) {
                sizeToCollectionList.get(currentSize).remove(collection);
            }
            Long newSize = currentSize + fileSize;
            collectionSizeMap.put(collection, newSize);
            sizeToCollectionList.computeIfAbsent(newSize, (k) -> new HashSet<String>()).add(collection);
        }

        public Long getTotalSize() {
            return this.totalSize;
        }

        public List<Collection> getTopCollectionsBySize(int n) {
            List<Collection> topCollections = new ArrayList();
            for(Long size : sizeToCollectionList.descendingKeySet()) {
                Set<String> list = sizeToCollectionList.get(size);
                for(String collection : list) {
                    topCollections.add(new Collection(collection, collectionSizeMap.get(collection)));
                    n--;
                    if(n == 0) break;
                }
                if(n == 0) break;
            }
            return topCollections;
        }
    }

    public void test() {
        FileSystem fileSystem = new FileSystem();
        fileSystem.addFile("File1", 100, "Collection1");
        fileSystem.addFile("File2", 20, "Collection1");
        System.out.println("Total Size : "+fileSystem.getTotalSize());
        fileSystem.addFile("File3", 100, "Collection2");
        fileSystem.addFile("File1", 200, "Collection2");
        fileSystem.addFile("File4", 100, "Collection3");
        System.out.println("Total Size : "+fileSystem.getTotalSize());
        System.out.println("Top N : "+fileSystem.getTopCollectionsBySize(2));
        System.out.println("Top N : "+fileSystem.getTopCollectionsBySize(4));
    }

    public static void main(String[] args) {
        new Coding().test();
    }
}
