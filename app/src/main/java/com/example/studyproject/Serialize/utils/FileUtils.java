package com.example.studyproject.Serialize.utils;

import android.content.Context;
import android.os.Environment;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * author : wangliyun
 * e-mail : wangliyun@szy.com
 * time   : 2019/11/07
 * desc   : 文件/目录(创建、删除、获取、是否文件文件···工具类)
 * version: 1.0
 */
public final class FileUtils {
    private static final String TAG = "FileUtils";

    public static boolean hasSDCard() {
        String status = Environment.getExternalStorageState();
        if (!status.equals(Environment.MEDIA_MOUNTED)) {
            return false;
        }
        return true;
    }



    private FileUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 按路径返回文件。
     *
     * @param filePath The path of file.
     * @return the file
     */
    public static File getFileByPath(final String filePath) {
        return isSpace(filePath) ? null : new File(filePath);
    }

    /**
     * 返回文件是否存在。
     *
     * @param filePath The path of file.
     */
    public static boolean isFileExists(final String filePath) {
        return isFileExists(getFileByPath(filePath));
    }

    /**
     * 返回文件是否存在。
     *
     * @param file The file.
     */
    public static boolean isFileExists(final File file) {
        return file != null && file.exists();
    }


    /**
     * 返回是否为目录.
     *
     * @param dirPath The path of directory.
     */
    public static boolean isDir(final String dirPath) {
        return isDir(getFileByPath(dirPath));
    }

    /**
     * 返回是否为目录.
     *
     * @param file The file.
     */
    public static boolean isDir(final File file) {
        return file != null && file.exists() && file.isDirectory();
    }


    /**
     * 返回是否为文件。
     *
     * @param filePath The path of file.
     */
    public static boolean isFile(final String filePath) {
        return isFile(getFileByPath(filePath));
    }

    /**
     * 返回是否为文件。
     *
     * @param file The file.
     */
    public static boolean isFile(final File file) {
        return file != null && file.exists() && file.isFile();
    }


    /**
     * 删除目录.
     *
     * @return {@code true}: success<br>{@code false}: fail
     */
    public static boolean deleteDir(final String dirPath) {
        return deleteDir(getFileByPath(dirPath));
    }

    /**
     * 删除目录
     *
     * @param dir 目录.
     */
    public static boolean deleteDir(final File dir) {
        if (dir == null) {
            return false;
        }
        // dir不存在，然后返回true
        if (!dir.exists()) {
            return true;
        }
        // dir不是目录，然后返回false
        if (!dir.isDirectory()) {
            return false;
        }
        File[] files = dir.listFiles();
        if (files != null && files.length != 0) {
            for (File file : files) {
                if (file.isFile()) {
                    if (!file.delete()) {
                        return false;
                    }
                } else if (file.isDirectory()) {
                    if (!deleteDir(file)) {
                        return false;
                    }

                }
            }
        }
        return dir.delete();
    }

    public static boolean deleteFile(final String srcFilePath) {
        return deleteFile(getFileByPath(srcFilePath));
    }

    public static boolean deleteFile(final File file) {
        return file != null && (!file.exists() || file.isFile() && file.delete());
    }

    public static boolean deleteAllInDir(final String dirPath) {
        return deleteAllInDir(getFileByPath(dirPath));
    }

    /**
     * Delete the all in directory.
     *
     * @param dir The directory.
     * @return {@code true}: success<br>{@code false}: fail
     */
    public static boolean deleteAllInDir(final File dir) {
        return deleteFilesInDirWithFilter(dir, new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return true;
            }
        });
    }

    /**
     * 如果目录不存在，请创建一个目录，否则不执行任何操作
     *
     * @param dirPath The path of directory.
     */
    public static boolean createOrExistsDir(final String dirPath) {
        return createOrExistsDir(getFileByPath(dirPath));
    }

    /**
     * 如果目录不存在，请创建一个目录，否则不执行任何操作
     *
     * @param file The file.
     */
    public static boolean createOrExistsDir(final File file) {
        return file != null && (file.exists() ? file.isDirectory() : file.mkdirs());
    }

    /**
     * 如果文件不存在，则创建它，否则不执行任何操作
     *
     * @param filePath The path of file.
     */
    public static boolean createOrExistsFile(final String filePath) {
        return createOrExistsFile(getFileByPath(filePath));
    }

    /**
     * 如果文件不存在，则创建它，否则不执行任何操作。.
     *
     * @param file The file.
     */
    public static boolean createOrExistsFile(final File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (!createOrExistsDir(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 如果文件不存在，请创建它，否则请在创建之前删除旧文件
     *
     * @param filePath The path of file.
     */
    public static boolean createFileByDeleteOldFile(final String filePath) {
        return createFileByDeleteOldFile(getFileByPath(filePath));
    }

    /**
     * 如果文件不存在，请创建它，否则请在创建之前删除旧文件。
     *
     * @param file The file.
     */
    public static boolean createFileByDeleteOldFile(final File file) {
        if (file == null) return false;
        // 文件存在，删除失败，然后返回false
        if (file.exists() && !file.delete()) {
            return false;
        }

        if (!createOrExistsDir(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 返回文件名
     *
     * @param file The file.
     */
    public static String getFileName(final File file) {
        if (file == null) return "";
        return getFileName(file.getAbsolutePath());
    }

    /**
     * 返回文件名
     *
     * @param filePath The path of file.
     * @return filePath
     */
    public static String getFileName(final String filePath) {
        if (isSpace(filePath)) {
            return "";
        }

        int lastSep = filePath.lastIndexOf(File.separator);
        return lastSep == -1 ? filePath : filePath.substring(lastSep + 1);
    }


    /**
     * 复制目录.
     *
     * @param srcDirPath  The path of source directory.
     * @param destDirPath The path of destination directory.
     */
    public static boolean copyDir(final String srcDirPath,
                                  final String destDirPath) {
        return copyDir(getFileByPath(srcDirPath), getFileByPath(destDirPath));
    }

    /**
     * 复制目录.
     *
     * @param srcDirPath  The path of source directory.
     * @param destDirPath The path of destination directory.
     * @param listener    The replace listener.
     */
    public static boolean copyDir(final String srcDirPath,
                                  final String destDirPath,
                                  final OnReplaceListener listener) {
        return copyDir(getFileByPath(srcDirPath), getFileByPath(destDirPath), listener);
    }

    /**
     * 复制目录.
     *
     * @param srcDir  The source directory.
     * @param destDir The destination directory.
     */
    public static boolean copyDir(final File srcDir,
                                  final File destDir) {
        return copyOrMoveDir(srcDir, destDir, false);
    }

    /**
     * 复制目录.
     *
     * @param srcDir   The source directory.
     * @param destDir  The destination directory.
     * @param listener The replace listener.
     */
    public static boolean copyDir(final File srcDir,
                                  final File destDir,
                                  final OnReplaceListener listener) {
        return copyOrMoveDir(srcDir, destDir, listener, false);
    }

    /**
     * 复制文件.
     *
     * @param srcFilePath  The path of source file.
     * @param destFilePath The path of destination file.
     * @return {@code true}: success<br>{@code false}: fail
     */
    public static boolean copyFile(final String srcFilePath,
                                   final String destFilePath) {
        return copyFile(getFileByPath(srcFilePath), getFileByPath(destFilePath));
    }

    /**
     * 复制文件.
     *
     * @param srcFilePath  The path of source file.
     * @param destFilePath The path of destination file.
     * @param listener     The replace listener.
     */
    public static boolean copyFile(final String srcFilePath,
                                   final String destFilePath,
                                   final OnReplaceListener listener) {
        return copyFile(getFileByPath(srcFilePath), getFileByPath(destFilePath), listener);
    }

    /**
     * 复制文件.
     *
     * @param srcFile  The source file.
     * @param destFile The destination file.
     */
    public static boolean copyFile(final File srcFile,
                                   final File destFile) {
        return copyOrMoveFile(srcFile, destFile, false);
    }

    /**
     * 复制文件.
     *
     * @param srcFile  The source file.
     * @param destFile The destination file.
     * @param listener The replace listener.
     */
    public static boolean copyFile(final File srcFile,
                                   final File destFile,
                                   final OnReplaceListener listener) {
        return copyOrMoveFile(srcFile, destFile, listener, false);
    }

    /**
     * 移动目录.
     *
     * @param srcDirPath  The path of source directory.
     * @param destDirPath The path of destination directory.
     */
    public static boolean moveDir(final String srcDirPath,
                                  final String destDirPath) {
        return moveDir(getFileByPath(srcDirPath), getFileByPath(destDirPath));
    }

    /**
     * 移动目录.
     *
     * @param srcDirPath  The path of source directory.
     * @param destDirPath The path of destination directory.
     * @param listener    The replace listener.
     */
    public static boolean moveDir(final String srcDirPath,
                                  final String destDirPath,
                                  final OnReplaceListener listener) {
        return moveDir(getFileByPath(srcDirPath), getFileByPath(destDirPath), listener);
    }

    /**
     * 移动目录.
     *
     * @param srcDir  The source directory.
     * @param destDir The destination directory.
     */
    public static boolean moveDir(final File srcDir,
                                  final File destDir) {
        return copyOrMoveDir(srcDir, destDir, true);
    }

    /**
     * 移动目录。
     *
     * @param srcDir   The source directory.
     * @param destDir  The destination directory.
     * @param listener The replace listener.
     */
    public static boolean moveDir(final File srcDir,
                                  final File destDir,
                                  final OnReplaceListener listener) {
        return copyOrMoveDir(srcDir, destDir, listener, true);
    }

    /**
     * 移动文件.
     *
     * @param srcFilePath  The path of source file.
     * @param destFilePath The path of destination file.
     * @return {@code true}: success<br>{@code false}: fail
     */
    public static boolean moveFile(final String srcFilePath,
                                   final String destFilePath) {
        return moveFile(getFileByPath(srcFilePath), getFileByPath(destFilePath));
    }

    /**
     * 移动文件
     *
     * @param srcFilePath  The path of source file.
     * @param destFilePath The path of destination file.
     * @param listener     The replace listener.
     */
    public static boolean moveFile(final String srcFilePath,
                                   final String destFilePath,
                                   final OnReplaceListener listener) {
        return moveFile(getFileByPath(srcFilePath), getFileByPath(destFilePath), listener);
    }

    /**
     * 移动文件.
     *
     * @param srcFile  The source file.
     * @param destFile The destination file.
     */
    public static boolean moveFile(final File srcFile,
                                   final File destFile) {
        return copyOrMoveFile(srcFile, destFile, true);
    }

    /**
     *移动文件.
     *
     * @param srcFile  The source file.
     * @param destFile The destination file.
     * @param listener The replace listener.
     */
    public static boolean moveFile(final File srcFile,
                                   final File destFile,
                                   final OnReplaceListener listener) {
        return copyOrMoveFile(srcFile, destFile, listener, true);
    }

    private static boolean copyOrMoveDir(final File srcDir,
                                         final File destDir,
                                         final boolean isMove) {
        return copyOrMoveDir(srcDir, destDir, new OnReplaceListener() {
            @Override
            public boolean onReplace() {
                return true;
            }
        }, isMove);
    }

    private static boolean copyOrMoveDir(final File srcDir,
                                         final File destDir,
                                         final OnReplaceListener listener,
                                         final boolean isMove) {
        if (srcDir == null || destDir == null) return false;
        // destDir's path locate in srcDir's path then return false
        String srcPath = srcDir.getPath() + File.separator;
        String destPath = destDir.getPath() + File.separator;
        if (destPath.contains(srcPath)) return false;
        if (!srcDir.exists() || !srcDir.isDirectory()) return false;
        if (destDir.exists()) {
            if (listener == null || listener.onReplace()) {// require delete the old directory
                if (!deleteAllInDir(destDir)) {// unsuccessfully delete then return false
                    return false;
                }
            } else {
                return true;
            }
        }
        if (!createOrExistsDir(destDir)) return false;
        File[] files = srcDir.listFiles();
        for (File file : files) {
            File oneDestFile = new File(destPath + file.getName());
            if (file.isFile()) {
                if (!copyOrMoveFile(file, oneDestFile, listener, isMove)) return false;
            } else if (file.isDirectory()) {
                if (!copyOrMoveDir(file, oneDestFile, listener, isMove)) return false;
            }
        }
        return !isMove || deleteDir(srcDir);
    }

    private static boolean copyOrMoveFile(final File srcFile,
                                          final File destFile,
                                          final boolean isMove) {
        return copyOrMoveFile(srcFile, destFile, new OnReplaceListener() {
            @Override
            public boolean onReplace() {
                return true;
            }
        }, isMove);
    }

    private static boolean copyOrMoveFile(final File srcFile,
                                          final File destFile,
                                          final OnReplaceListener listener,
                                          final boolean isMove) {
        if (srcFile == null || destFile == null) return false;
        // srcFile equals destFile then return false
        if (srcFile.equals(destFile)) return false;
        // srcFile doesn't exist or isn't a file then return false
        if (!srcFile.exists() || !srcFile.isFile()) return false;
        if (destFile.exists()) {
            if (listener == null || listener.onReplace()) {// require delete the old file
                if (!destFile.delete()) {// unsuccessfully delete then return false
                    return false;
                }
            } else {
                return true;
            }
        }
        if (!createOrExistsDir(destFile.getParentFile())) return false;
        try {
            return writeFileFromIS(destFile, new FileInputStream(srcFile))
                    && !(isMove && !deleteFile(srcFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 删除目录中满足过滤条件的所有文件。
     *
     * @param dir    The directory.
     * @param filter The filter.
     */
    public static boolean deleteFilesInDirWithFilter(final File dir, final FileFilter filter) {
        if (dir == null) return false;
        // dir doesn't exist then return true
        if (!dir.exists()) return true;
        // dir isn't a directory then return false
        if (!dir.isDirectory()) return false;
        File[] files = dir.listFiles();
        if (files != null && files.length != 0) {
            for (File file : files) {
                if (filter.accept(file)) {
                    if (file.isFile()) {
                        if (!file.delete()) return false;
                    } else if (file.isDirectory()) {
                        if (!deleteDir(file)) return false;
                    }
                }
            }
        }
        return true;
    }
    private static boolean writeFileFromIS(final File file,
                                           final InputStream is) {
        OutputStream os = null;
        try {
            os = new BufferedOutputStream(new FileOutputStream(file));
            byte data[] = new byte[8192];
            int len;
            while ((len = is.read(data, 0, 8192)) != -1) {
                os.write(data, 0, len);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private static boolean isSpace(final String s) {
        if (s == null) return true;
        for (int i = 0, len = s.length(); i < len; ++i) {
            if (!Character.isWhitespace(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * author : wangliyun
     * e-mail : wangliyun@szy.com
     * time   : 2019/11/21
     * desc   : 移动目录监听
     * version: 1.0
     */
    public static interface OnReplaceListener {
        boolean onReplace();
    }

    public static String readAssetsFileData(Context context, String fileName) {
        InputStream is = null;
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;

        String str;
        try {
            is = context.getAssets().open(fileName);
            reader = new InputStreamReader(is);
            bufferedReader = new BufferedReader(reader);
            StringBuffer buffer = new StringBuffer("");

            while((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
                buffer.append("\n");
            }

            String var7 = buffer.toString();
            return var7;
        } catch (Exception var25) {
            var25.printStackTrace();
            str = null;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                    bufferedReader = null;
                } catch (Exception var24) {
                    var24.printStackTrace();
                }
            }

            if (reader != null) {
                try {
                    reader.close();
                    reader = null;
                } catch (Exception var23) {
                    var23.printStackTrace();
                }
            }

            if (is != null) {
                try {
                    is.close();
                    is = null;
                } catch (Exception var22) {
                    var22.printStackTrace();
                }
            }

        }

        return str;
    }
}
