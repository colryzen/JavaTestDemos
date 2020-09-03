package com.example.file;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import java.util.Map;

import io.minio.PostPolicy;
import org.joda.time.DateTime;
import org.xmlpull.v1.XmlPullParserException;

import io.minio.MinioClient;
import io.minio.errors.MinioException;

public class FileUploader {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException, InvalidKeyException, XmlPullParserException {
        try {
            // 使用MinIO服务的URL，端口，Access key和Secret key创建一个MinioClient对象
            MinioClient minioClient = new MinioClient("http://127.0.0.1", 9000, "AKIAIOSFODNN7EXAMPLE", "wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY");

            // 检查存储桶是否已经存在
            boolean isExist = minioClient.bucketExists("test");
            if (isExist) {
                System.out.println("Bucket already exists.");
            } else {
                // 创建一个名为asiatrip的存储桶，用于存储照片的zip文件。
                minioClient.makeBucket("asiatrip");
            }

            // 使用putObject上传一个文件到存储桶中。
            //  minioClient.putObject("asiatrip","asiaphotos.zip", "/home/user/Photos/asiaphotos.zip");
            //  System.out.println("/home/user/Photos/asiaphotos.zip is successfully uploaded as asiaphotos.zip to `asiatrip` bucket.");

            postPolicy(minioClient);
            putObject(minioClient);

        } catch (MinioException e) {
            System.out.println("11 Error occurred: " + e);
        }
    }

    private static void postPolicy(MinioClient minioClient) throws XmlPullParserException, NoSuchAlgorithmException, InvalidKeyException, IOException {
        try {
            PostPolicy policy = new PostPolicy("test", "996",
                    DateTime.now().plusDays(7));
            policy.setContentType("image/png");
            Map<String, String> formData = minioClient.presignedPostPolicy(policy);
            System.out.print("curl -X POST ");
            for (Map.Entry<String, String> entry : formData.entrySet()) {
                System.out.print(" -F " + entry.getKey() + "=" + entry.getValue());
            }
            System.out.println(" -F file=@/tmp/userpic.png  https://play.min.io/mybucket");
        } catch (MinioException e) {
            System.out.println("Error occurred: " + e);

        }
    }

    private static void putObject(MinioClient minioClient) throws XmlPullParserException, NoSuchAlgorithmException, InvalidKeyException, IOException {
        try {
            String url = minioClient.presignedPutObject("test", "myobject.png", 60 * 60 * 24);
            System.out.println("地址；"+url);
        } catch (MinioException e) {
            System.out.println("Error occurred: " + e);
        }
    }

}
