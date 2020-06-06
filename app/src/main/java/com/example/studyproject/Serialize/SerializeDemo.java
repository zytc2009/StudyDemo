package com.example.studyproject.Serialize;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.studyproject.Serialize.bean.parcelable.FeedCommentsBean;
import com.example.studyproject.Serialize.bean.parcelable.ParseBean;
import com.example.studyproject.Serialize.bean.PersonBean;
import com.example.studyproject.Serialize.bean.BaseTypeBean;
import com.example.studyproject.Serialize.utils.DataParserUtil;
import com.example.studyproject.Serialize.utils.FileUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SerializeDemo extends AppCompatActivity {

    public static void main(String[] args) {
        testSerialize();

    }

    public static void start(Context context){
        Intent intent = new Intent(context,SerializeDemo.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        testSerializeParseTime();
    }

    public void testSerializeParseTime(){
        long startTime = System.currentTimeMillis();


        try {

            String result = FileUtils.readAssetsFileData(this, "downrefresh.txt");

            JSONObject jo = DataParserUtil.parseAsJSONObject(result);

            JSONObject data = DataParserUtil.getJsonObj(jo, "body");

            Map<String, BaseTypeBean> tempFeedsMap = new HashMap<>();
            //解析feed
            JSONArray feedsContent = DataParserUtil.getJsonArr(data, "feeds");
            List<BaseTypeBean> feedsList = new ArrayList<>();
            List<BaseTypeBean> stickyPostList = new ArrayList<>();
            parseSchoolFeedArray(feedsContent, tempFeedsMap, feedsList, stickyPostList);

            //处理点赞和评论数据
            JSONArray commentsContent = DataParserUtil.getJsonArr(data, "feedComments");
            if (null != commentsContent && commentsContent.size() > 0) {
                for (int i = 0; i < commentsContent.size(); i++) {
                    JSONObject jsonObject = commentsContent.getJSONObject(i);
                    JSONObject commentsBean = DataParserUtil.getJsonObj(jsonObject, "commentInfo");
                    if (commentsBean == null) {
                        continue;
                    }
                    FeedCommentsBean feedCommentsBean = DataParserUtil.parseObject(commentsBean, FeedCommentsBean.class);
                    if (feedCommentsBean != null) {
                        String contentId = DataParserUtil.getJsonStr(jsonObject, "contentId");
                        String contentType = DataParserUtil.getJsonStr(jsonObject, "contentType");
                        String keys = contentType + "_" + contentId;
                        if (tempFeedsMap.containsKey(keys)) {
                            ParseBean bean = (ParseBean) tempFeedsMap.get(keys);
                            if (bean.isStickyPost()) {
                                feedCommentsBean.setComments(null);
                            }
                            bean.setFeedCommentsBean(feedCommentsBean);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        long endTime = System.currentTimeMillis();
        System.out.println("testSerializeParseTime = " + (endTime - startTime));
    }


    public static void parseSchoolFeedArray(JSONArray feedsContent, Map<String, BaseTypeBean> feedsMap,
                                            List<BaseTypeBean> feedsList, List<BaseTypeBean> tempStickyPostList) {
        if (null != feedsContent && feedsContent.size() > 0) {
            for (int i = 0; i < feedsContent.size(); i++) {
                JSONObject jsonObject = feedsContent.getJSONObject(i);
                ParseBean bean = parseItem(jsonObject);
                if (bean == null) {
                    continue;
                }
                if (bean.isStickyPost()) {
                    tempStickyPostList.add(bean);
                } else {
                    feedsList.add(bean);
                }
                if (feedsMap != null) {
                    String contentId = DataParserUtil.getJsonStr(jsonObject, "contentId");
                    String contentType = DataParserUtil.getJsonStr(jsonObject, "contentType");
                    String keys = contentType + "_" + contentId;
                    feedsMap.put(keys, bean);
                }
            }
        }
    }

    public static ParseBean parseItem(JSONObject jsonObject) {
        if (null == jsonObject) {
            return null;
        }
        Class clazz = ParseBean.class;
        ParseBean bean = (ParseBean) DataParserUtil.parseObject(jsonObject, clazz);
        return bean;
    }

    public static void testSerialize(){
        try {
//            writeObj();
            readObj();
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("文件读取异常 error message = " + e.getMessage());
        }
    }


    public static void writeObj() throws Exception {
        ObjectOutputStream objout = new ObjectOutputStream(new FileOutputStream("/Users/zhangshujia/wyc/person.obj",false));
        objout.writeObject(new PersonBean("gir",30));
        objout.close();
    }

    public static void readObj() throws Exception {
        ObjectInputStream objin = new ObjectInputStream(new FileInputStream("/Users/zhangshujia/wyc/person.obj"));
        PersonBean p = (PersonBean)objin.readObject();
        objin.close();
        System.out.println(p);
    }


}
