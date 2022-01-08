package com.util;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

//import org.springframework.util.StringUtils;


public class FileUtil {
	
	public static void main(String args[]) {
		String path="D:\\fileServer\\files\\report_html\\2019041118595034303";
		String npath = FileUtil.getChinsePath(path);



	}

	/**
	 * 文件夹有中文改为汉语拼音
	 */
	public static boolean changeDirtoPinyin(String path){
		String pathname=getChinsePath(path);
		if(isChineseChar(pathname)){
			// 转拼音
			HanyuPinyinHelper h=new HanyuPinyinHelper();
			String newpath = h.toHanyuPinyin(pathname);

			// 换文件名
			FileUtil.changeDirName(pathname,newpath);
		}
		return true;
	}


	public static String  getChinsePath(String path){
		String msg=null;
		File file = new File(path);
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++) {
			if(files[i].isDirectory()){
				 String filename = files[i].toString();
				 msg=filename;
			}
		}
		return msg;
	}


	/**
	 * 校验一个字符是否是汉字
	 *
	 * @param c
	 *  被校验的字符
	 * @return true代表是汉字
	 */
	public static boolean isChineseChar(String str) {
		boolean b = false;
		try {

			char[] strChar = str.toCharArray();
			for (char a:strChar){
				if(String.valueOf(a).getBytes("UTF-8").length > 1){
					b=true;
				}
			}
			return b;
		} catch (Exception e) {
			e.printStackTrace();
			return b;
		}
	}

	public static void changeDirName(String opath,String npath){
		File file1 = new File(opath);
		//将原文件夹更改为A，其中路径是必要的。注意
		System.out.print("文件名由"+opath);
		System.out.println("===》成功改为："+npath);
		file1.renameTo(new File(npath));

	}


	/**
	 * 检索文件夹
	 * 重命名文件
	 * @param path
	 */
	public static void searchFiles(String path){
		File file = new File(path);
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++) {
			if(files[i].isDirectory()){
				searchFiles(files[i].toString());
			}else{
				String name = files[i].getAbsolutePath();//newSong\\
				String nameStr = files[i].getName().substring(1,files[i].getName().length());
				files[i].renameTo(new File("G:\\song\\"+nameStr));
			}
		}
	}


	/**
	 * 复制文件夹的测试方法
	 */
	public static void test() {
		// 复制方法
		copyDir("D:\\fileServer\\autoops\\zip", "D:\\fileServer\\autoops\\html_report");
		// 打印完成
		System.out.println("文件拷贝完成!");
	}


	
	  public static List<File> searchFiles(File folder, final String keyword) {
	        List<File> result = new ArrayList<File>();
	        if (folder.isFile())
	            result.add(folder);
	 
	        File[] subFolders = folder.listFiles(new FileFilter() {
	            @Override
	            public boolean accept(File file) {
	                if (file.isDirectory()) {
	                    return true;
	                }
	                if (file.getName().toLowerCase().contains(keyword)) {
	                    return true;
	                }
	                return false;
	            }
	        });
	        
	        /*查找后缀名
	         * File[] subFolders = folder.listFiles(new FileFilter() {
	            @Override
	            public boolean accept(File fileServer) {
	                if (fileServer.isDirectory()) {
	                    return true;
	                }
	                if (fileServer.getName().toLowerCase().endsWith(keyword)) {
	                    return true;
	                }
	                return false;
	            }
	        });*/
	 
	        if (subFolders != null) {
	            for (File file : subFolders) {
	                if (file.isFile()) {
	                    // 如果是文件则将文件添加到结果列表中
	                    result.add(file);
	                } else {
	                    // 如果是文件夹，则递归调用本方法，然后把所有的文件加到结果列表中
	                    result.addAll(searchFiles(file, keyword));
	                }
	            }
	        }
	        return result;
	    }
	 

	private static String getResourcePath() {
		String className = FileUtil.class.getName();
		String classNamePath = className.replace(".", "/") + ".class";
		URL is = FileUtil.class.getClassLoader().getResource(classNamePath);
		String path = is.getFile();
		// path = StringUtils.replace(path, "%20", " ");

		return path;
	}

	/**
	 * 获取文件名
	 * 
	 * @param str
	 * @return
	 */
	public static String pathSwitch(String str) {
		File f = null;
		StringBuffer filepath = new StringBuffer();
		if (str != null || str != "") {
			f = new File(str);
			if (f.exists()) {
				filepath.append(f.getParent());
//				filepath.append("\\");
				filepath.append("/");
			}
		}

		if (f.exists()) {
			filepath.append(f.getName());
		}
		return filepath.toString();
	}

	 

	 

 

	/**
	 * java文件搜索
	 * 
	 * @param strPath
	 * @throws Exception
	 */
	public static void getDir(String strPath) throws Exception {
		try {
			File f = new File(strPath);
			if (f.isDirectory()) {
				File[] fList = f.listFiles();
				for (int j = 0; j < fList.length; j++) {
					if (fList[j].isDirectory()) {
						System.out.println(fList[j].getPath());
						getDir(fList[j].getPath()); // 在getDir函数里面又调用了getDir函数本身
					}
				}
				for (int j = 0; j < fList.length; j++) {

					if (fList[j].isFile()) {
						System.out.println(fList[j].getPath());// 把这话换成你要处理的语句.比如
																// fList[j].substring(fList[j].length-3,3)=="txt"
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	 

	/**
	 * 复制单个文件
	 * 
	 * @param srcFileName
	 *            待复制的文件名
	 * @param descFileName
	 *            目标文件名
	 * @param overlay
	 *            如果目标文件存在，是否覆盖
	 * @return 如果复制成功返回true，否则返回false
	 */
	public static boolean copyFile(String srcFileName, String destFileName, boolean overlay) {

		String MESSAGE = "";
		File srcFile = new File(srcFileName);

		// 判断源文件是否存在
		if (!srcFile.exists()) {
			MESSAGE = "源文件：" + srcFileName + "不存在！";
			JOptionPane.showMessageDialog(null, MESSAGE);
			return false;
		} else if (!srcFile.isFile()) {
			MESSAGE = "复制文件失败，源文件：" + srcFileName + "不是一个文件！";
			JOptionPane.showMessageDialog(null, MESSAGE);
			return false;
		}

		// 判断目标文件是否存在
		File destFile = new File(destFileName);
		if (destFile.exists()) {
			// 如果目标文件存在并允许覆盖
			if (overlay) {
				// 删除已经存在的目标文件，无论目标文件是目录还是单个文件
				new File(destFileName).delete();
			} else {
				return false;
			}
		} else {
			// 如果目标文件所在目录不存在，则创建目录
			if (!destFile.getParentFile().exists()) {
				// 目标文件所在目录不存在
				if (!destFile.getParentFile().mkdirs()) {
					// 复制文件失败：创建目标文件所在目录失败
					return false;
				}
			}
			System.out.println(destFile.getPath() + "路径成功创建！");
		}

		// 复制文件
		int byteread = 0; // 读取的字节数
		InputStream in = null;
		OutputStream out = null;

		try {
			in = new FileInputStream(srcFile);
			out = new FileOutputStream(destFile);
			byte[] buffer = new byte[1024];

			while ((byteread = in.read(buffer)) != -1) {
				out.write(buffer, 0, byteread);
			}
			System.out.print(destFile.getPath() + "成功写入！");
			return true;
		} catch (FileNotFoundException e) {
			return false;
		} catch (IOException e) {
			return false;
		} finally {
			try {
				if (out != null)
					out.close();
				if (in != null)
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 复制文件夹
	 * 
	 * @param src
	 *            源目录
	 * @param des
	 *            待拷贝的目录
	 * @throws Exception
	 */
	public static void copyDir(String src, String des) {
		// 初始化文件复制
		File file1 = new File(src);
		// 把文件里面内容放进数组
		File[] fs = file1.listFiles();

		// 初始化文件粘贴
		File file2 = new File(des);
		// 判断是否有这个文件有不管没有创建
		if (!file2.exists()) {
			file2.mkdirs();
		}
		// 遍历文件及文件夹
		for (File f : fs) {
			if (f.isFile()) {
				// 文件
				try {
//					fileCopy(f.getPath(), des + "\\" + f.getName());
					fileCopy(f.getPath(), des + "/" + f.getName());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // 调用文件拷贝的方法
			} else if (f.isDirectory()) {
				// 文件夹
//				copyDir(f.getPath(), des + "\\" + f.getName());// 继续调用复制方法 递归的地方,自己调用自己的方法,就可以复制文件夹的文件夹了
				copyDir(f.getPath(), des + "/" + f.getName());// 继续调用复制方法 递归的地方,自己调用自己的方法,就可以复制文件夹的文件夹了
			}
		}

	}


	/**
	 * 文件复制的具体方法
	 */
	private static void fileCopy(String src, String des) throws Exception {
		// io流固定格式
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(des));
		int i = -1;// 记录获取长度
		byte[] bt = new byte[2014];// 缓冲区
		while ((i = bis.read(bt)) != -1) {
			bos.write(bt, 0, i);
		}
		bis.close();
		bos.close();
		// 关闭流
	}

	/**
	 * 删除文件
	 */
	public static int delFile(String fpath) {
		int isSucc = 0;
		File f = new File(fpath);
		if (f.exists()) {
			f.delete();
			isSucc = 1;
		}
		return isSucc;
	}

	/**
	 * 删除文件夹
	 * 
	 * @param folderPath
	 */
	public static void delFolder(String folderPath) {
		try {
			delAllFile(folderPath); // 删除完里面所有内容
			String filePath = folderPath;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			myFilePath.delete(); // 删除空文件夹
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean delAllFile(String path) {
		boolean flag = false;
		File file = new File(path);
		if (!file.exists()) {
			return flag;
		}
		if (!file.isDirectory()) {
			return flag;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + "/" + tempList[i]);// 先删除文件夹里面的文件
				delFolder(path + "/" + tempList[i]);// 再删除空文件夹
				flag = true;
			}
		}
		return flag;
	}



	/**************************************************/
	 /**
     * 毫秒级时间
     * @return
     */
    public static String getNewFileName(){
        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String str=sdf.format(new Date());
        
    	Random rand = new Random(); 
		int num = rand.nextInt(100)+1; 
		// rand.nextInt(3)输出的是：0-1-2
		if(num<10) {
			str+="0"+num;
		}else {
			str+=""+num;
		}
        
        
        return str;
    }

    /**
     * 获取文件名
     * @param str
     * @return
     */ 
    public static String getFileName(String str){
        File f=new File(str);
        if(f.exists()){
            return f.getName();
        }
        return "文件不存在？";
    }
    

    /**
     * 字符串的文件名（去后缀）
     * @param filename
     * @return
     */
    public static String getFileNameUnExten(String fileName) {
		String prefix = "";		
		if(fileName!=null&&fileName!="") {
			if(fileName.contains(".")) {
				prefix = fileName.substring(0,fileName.lastIndexOf("."));
			}else {
				prefix = "文件名无后缀";
			}
		}else {
			prefix = "文件名为空！";
		}

		return prefix;
	}

     /**
     * 获取文件路径
     * @param str
     * @return
     */ 
    public static String getFilePath(String str){
        if(str!=null|| str!=""){
            File f=new File(str);
            if(f.exists()){
                return f.getParent();
            }
        }
        return "";
    }
    


     /**
     *
     * @param destDirName
     * @return
     */ 
    public static boolean createDir(String destDirName) {
        File dir = new File(destDirName);
        if (dir.exists()) {
//            System.out.println("目录" + destDirName + "已经存在! 不再次创建");
            return false;
        }
        if (!destDirName.endsWith(File.separator)) {
            destDirName = destDirName + File.separator;
        }
        //创建目录
        if (dir.mkdirs()) {
            System.out.println("创建目录" + destDirName + "成功！");
            return true;
        } else {
            System.out.println("创建目录" + destDirName + "失败！");
            return false;
        }
    }

    

    /**
     * 字符串截取  获取文件后缀名
     * @param str
     * @return
     */ 
    public static String getFileExten4Str(String oldName){
//            String oldName = "E:\\test\\aaa.xls";
            int indexStart = oldName.indexOf(".");
            String str=oldName.substring(indexStart, oldName.length());
            System.out.println(str);
            return str;
    }

     /**
     * 获取文件后缀名
     * @param str
     * @return
     */ 
    public static String getFileExten(String str){
        File f =new File(str);
        String fileName=f.getName();
        String prefix=fileName.substring(fileName.lastIndexOf(".")+1);
        return "."+prefix;
    }
 
	
	
}
