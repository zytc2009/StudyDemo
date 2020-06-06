package com.example.studyproject.Serialize.utils;

import android.os.Environment;

import java.io.File;

/**
 * author : wangliyun
 * e-mail : wangliyun@szy.com
 * time   : 2019/11/15
 * desc   : 文件统一
 * version: 1.0
 */
public class FileDirHelper {

    private static final String TAG = "FileDirHelper";

    private static final String SEPARATOR = File.separator;

    /**父目录*/
    private static final String PARENT_DIRECTORY = SEPARATOR + "serialize" + SEPARATOR;

    /**
     * 获取业务文件路径
     * 需要申请存储权限
     * @return string
     */
    public static String getBusinessFilePath( String dirName) {
        try {
            //Sdcard 不存在，保存至私有目录
            if (!existsSdcard()) {
                return Environment.getExternalStorageDirectory() + SEPARATOR + PARENT_DIRECTORY +SEPARATOR + dirName;
            }
            File file = new File(Environment.getExternalStorageDirectory()
                    + PARENT_DIRECTORY + dirName);
            if (!FileUtils.isFileExists(file)) {
                boolean createState = FileUtils.createOrExistsDir(file);
            }
            return file.getAbsolutePath() + SEPARATOR;
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 判断外置sdcard是否可以正常使用
     *
     * @return
     */
    public static Boolean existsSdcard() {
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable();
    }

}
