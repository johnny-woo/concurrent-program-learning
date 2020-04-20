package com.woo.forkjoinlearn.demo;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTask2 {

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        FileTask fileTask = new FileTask(Paths.get("C:\\Users\\Johnny woo\\Downloads"));
        int count = forkJoinPool.invoke(fileTask);
        System.out.println("下载目录中共有" + count + "个文件");
        System.out.println("Main thread end.");
    }

    static class FileTask extends RecursiveTask<Integer> {
        private Path dr;

        public FileTask(Path dr) {
            this.dr = dr;
        }

        @Override
        protected Integer compute() {
            int count = 0;
            try {
                DirectoryStream<Path> directoryStream = Files.newDirectoryStream(dr);
                for (Path path : directoryStream) {
                    if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
                        FileTask fileTask = new FileTask(path);
                        fileTask.fork();
                        count += fileTask.join();
                    } else {
                        count += 1;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(dr + "目录下共有" + count + "个文件");
            return count;
        }
    }
}
