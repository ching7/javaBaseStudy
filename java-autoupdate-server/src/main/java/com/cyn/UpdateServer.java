package com.cyn;


import sun.net.TelnetInputStream;
import sun.net.ftp.FtpClient;
import sun.net.ftp.FtpDirEntry;
import sun.net.ftp.FtpProtocolException;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.*;

/**
 * 文件描述
 *
 * @ProjectName: java-autoupdate-server
 * @Package: com.cyn
 * @Date 2020/5/15 13:53
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
public class UpdateServer {
    private static String ftpUlr = "192.168.102.242";
    private static int ftpPort = 5212;
    private static String ftpUname = "uf30-dev";
    private static String ftpUpwd = "uf30@j&F";
    private static String updateServer = "smp";
    private static String updatePackage = "svr";

    public static void main(String[] args) throws Exception {

        //1 ftp 登陆
        //2 获取对应微服务最新包
        //3 登陆see
        //4 上传最新微服务包
        //5 升级最新微服务
        //6 关闭ftp链接

        try {
            //1 ftp登陆
            FtpClient ftpClient = connectFtp(ftpUlr, ftpPort, ftpUname, ftpUpwd);

            //2 获取对应微服务最新包
            String wordDir = "/日常集成/"+updateServer+"/";
            ftpClient.changeDirectory(wordDir);
            System.out.println("已登录到" + ftpClient.getWorkingDirectory() + "目录");
            Iterator<FtpDirEntry> fs = ftpClient.listFiles(wordDir);
            Map<String, String> serverMap = getLatestFileName(ftpClient, wordDir);
            String latestFileName = serverMap.get(updatePackage);
            while (fs.hasNext()) {
                FtpDirEntry file = fs.next();
                if (latestFileName.equals(file.getName())) {
                    downloadFile(ftpClient, file.getName(), "D:\\java-auto-update\\" + file.getName());
                    break;
                }
            }
            ftpClient.close();

            //3 登陆see

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 登陆ftp
     *
     * @param url
     * @param port
     * @param username
     * @param password
     * @return
     */
    public static FtpClient connectFtp(String url, int port, String username, String password) {
        //创建ftp
        FtpClient ftp = null;
        try {
            //创建地址
            SocketAddress addr = new InetSocketAddress(url, port);
            //连接
            ftp = FtpClient.create();
            ftp.connect(addr);
            //登陆
            ftp.login(username, password.toCharArray());
            ftp.setBinaryType();
        } catch (FtpProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ftp;
    }

    /**
     * 从ftp下载文件到本地
     *
     * @param filename    服务器上的文件名
     * @param newfilename 本地生成的文件名
     * @return
     * @throws Exception
     */
    public static long downloadFile(FtpClient ftpClient, String filename, String newfilename) {
        long result = 0;
        InputStream is = null;
        FileOutputStream os = null;
        try {
            is = ftpClient.getFileStream(filename);
            java.io.File outfile = new java.io.File(newfilename);
            os = new FileOutputStream(outfile);
            byte[] bytes = new byte[1024];
            int c;
            while ((c = is.read(bytes)) != -1) {
                os.write(bytes, 0, c);
                result = result + c;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FtpProtocolException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 获取指定目录下的微服务最新文件
     *
     * @param ftpClient
     * @return
     */
    public static Map<String, String> getLatestFileName(FtpClient ftpClient, String dir) throws IOException, FtpProtocolException {
        Map<String, String> serverMap = new HashMap<String, String>();
        Map<Date, String> svrMap = new HashMap<Date, String>();
        Map<Date, String> webMap = new HashMap<Date, String>();
        Iterator<FtpDirEntry> iterator = ftpClient.listFiles(dir);
        while (iterator.hasNext()) {
            FtpDirEntry ftpDirEntry = iterator.next();
            Date lastModified = ftpDirEntry.getLastModified();
            String fileName = ftpDirEntry.getName();
            if (fileName.contains("broker-" + updateServer + "-svr")) {
                svrMap.put(lastModified, fileName);
            }
            if (fileName.contains("broker-" + updateServer + "-web")) {
                webMap.put(lastModified, fileName);
            }
        }
        Map<Date, String> latestSvr = getLatestMap(svrMap);
        Map<Date, String> latestWeb = getLatestMap(webMap);
        latestSvr.forEach((date, name) -> {
            serverMap.put("svr", name);
        });
        latestWeb.forEach((date, name) -> {
            serverMap.put("web", name);
        });

        return serverMap;
    }

    /**
     * 获取最新包
     *
     * @param map
     * @return
     */
    public static Map<Date, String> getLatestMap(Map<Date, String> map) {
        Map<Date, String> latest = new HashMap<Date, String>();
        Collection<Date> c = map.keySet();
        Object[] obj = c.toArray();
        Arrays.sort(obj);
        int dateL = obj.length;
        Date var1 = (Date) obj[dateL - 1];
        String var2 = map.get(var1);
        latest.put(var1, var2);
        return latest;
    }
}
