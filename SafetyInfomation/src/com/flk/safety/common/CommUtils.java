package com.flk.safety.common;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.security.MessageDigest;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.StringTokenizer;
import java.util.TimeZone;

//import org.htmlparser.Parser;
//import org.htmlparser.util.NodeList;

/**
 * Common utility class
 *
 * @author ngc
 *
 */
public class CommUtils {


	/**
	 * null, 공백문자 체크
	 *
	 * @param str 체크할 문자열
	 * @param str2 str이 빈문자열일 경우 대체할 문자열
	 * @return 체크된 문자열. str이 null일 경우 str2
	 */
	public static String checkNull(String str, String str2) {
		if (str == null || str.trim().equals("")) {
			return str2;
		}
		return str.trim();
	}

	/**
	 * null check. str이 null일 경우 공백문자열을 되돌린다.
	 *
	 * @param str 체크할 문자열
	 * @return str.trim()
	 */
	public static String checkNull(String str) {
		if (str == null || str.equals("null")) {
			return "";
		}
		return str.trim();
	}

	/**
	 * null check. 파라메터로 넘어온 값을 그대로 되돌린다.
	 *
	 * @param str boolean value
	 * @return str
	 */
	public static boolean checkNull(boolean str) {
		return str;
	}

	/**
	 * null check. 파라메터로 넘어온 값을 그대로 되돌린다.
	 *
	 * @param str int value
	 * @return str
	 */
	public static int checkNull(int str) {
		return str;
	}

	/**
	 * null check. 파라메터로 넘어온 값을 그대로 되돌린다.
	 *
	 * @param str long value
	 * @return str
	 */
	public static long checkNull(long str) {
		return str;
	}

	/**
	 * null check. 파라메터로 넘어온 값을 그대로 되돌린다.
	 *
	 * @param str float value
	 * @return str
	 */
	public static float checkNull(float str) {
		return str;
	}

	/**
	 * null check. 파라메터로 넘어온 값을 그대로 되돌린다.
	 *
	 * @param str double value
	 * @return str
	 */
	public static double checkNull(double str) {
		return str;
	}

	/**
	 * 문자열에 포함된 html 태그 기호를 html code로 변환.
	 *
	 * @param str 변환할 문자열
	 * @return 변환된 문자열
	 */
	public static String convertString(String str) {
		String buf;
		buf = str;

		buf = replaceString(buf, "&", "&amp;");
		buf = replaceString(buf, "<", "&lt;");
		buf = replaceString(buf, ">", "&gt;");
	//	웹에서 인식하지 못하는 문자에 대한 처리로 인해서...
	//  buf = replaceString(buf, "'", "&apos;");
	//	buf = replaceString(buf, "\"", "&quot;");

		return buf;
	}

	/**
	 * str 문자열에 포함된 from 문자열을 to 문자열로 갱신한다.
	 *
	 * @param str 원문 문자열
	 * @param from str 문자열에 포함된 변환할 문자열
	 * @param to 변환될 문자열
	 * @return replace된 문자열.
	 */
	public static String replaceString (String str, String from, String to) {
		StringBuffer buf = new StringBuffer();
		int idx_start = 0;
		int idx_temp = 0;

		idx_start = str.indexOf(from);
		while((idx_start <= str.length()) && (idx_start >= 0)) {
			buf.append(str.substring(idx_temp, idx_start));
			buf.append(to);

			idx_temp = idx_start + from.length();
			idx_start = str.indexOf(from, idx_temp);
		}
		buf.append(str.substring(idx_temp, str.length()));

		return buf.toString();
	}

	/**
	 * 현재 시간을 yyyyMMddHHmmss 형식으로 리턴한다.
	 *
	 * @return yyyyMMddHHmmss 형식 문자열
	 */
	public static String getTimeStamp() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat ("yyyyMMddHHmmss");
		return formatter.format(date);
	}

	/**
	 * 현재 시간을 format 형식의 문자열로 변환한다.
	 *
	 * @param format 변환할 형식
	 * @return 변환 문자열
	 */
	public static String getTimeStamp(String format) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat (format);
		return formatter.format(date);
	}

	/**
	 * 주어진 시간을 주어진 형식의 문자열로 변환한다.
	 * @param d 주어진 시간
	 * @param format 변환할 형식
	 * @return 변환 문자열
	 */
	public static String formatDate(java.util.Date d, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(d);
	}

	/**
	 * Returns this Calendar's time value in milliseconds.
	 * @return the current time as UTC milliseconds from the epoch
	 */
	public static long getTimeInMillis(){
		Calendar cal = Calendar.getInstance();
		return cal.getTimeInMillis() ;
	}

	/**
	 * 문자열 패딩하기(length=5이면 25 -> 00025).
	 *
	 * @param str 문자열
	 * @param length 길이
	 * @return 패딩된 문자열
	 */
	public static String setStringPadding(String str, int length) {
		return setStringPadding(str, length, '0');
	}

	/**
	 * 문자열을 blankChar로 채워서 length 길이로 만든다.
	 * @param str 패딩할 문자열
	 * @param length 문자열의 전체 길이
	 * @param blankChar 채울 문자
	 * @return 패딩된 문자열
	 */
	public static String setStringPadding(String str, int length, char blankChar) {

		if(str == null || str.equals("")) return str;

		StringBuffer returnValue = new StringBuffer();

		byte[] asciiChar = str.getBytes();
		if ( asciiChar == null ) asciiChar = new byte[length];

		int len = asciiChar.length;
		int i = 0;
		if ( len > length ) {
			for ( i = 0 ; i < length ; i++ ) {
				returnValue.append(asciiChar[ (len - 1) - i] );
			}
		}
		else if ( len == length ) {
			return str;
		}
		else {
			returnValue.append(str);
			returnValue.reverse();
			for ( i = len ; i < length ; i++ ) {
				returnValue.append(blankChar);
			}
		}
		returnValue.reverse();
		return returnValue.toString();
	}

	/**
	 * 주어진 문자열의 길이가 length 길이 보다 작을 경우 <br>
	 * 문자열 뒤에 공백문자를 붙여 length 길이로 만들어 반환한다.
	 * @param str 변환할 문자열
	 * @param length 변환할 길이
	 * @return str의 길이가 length보다 작을 경우 공백이 추가된 문자열. <br/>
	 * 	length보다 길면 원래문자열을 그대로 되돌린다.
	 */
	public static String blankPadding(String str, int length) {
		return stringPadding(str, length, (byte)' ');
	}

	/**
	 * 주어진 문자열의 길이가 length 길이 보다 작을 경우 <br/>
	 * pad byte를 문자열 뒤에 붙여 length 길이로 만들어 반환한다.
	 * @param str 변환할 문자열
	 * @param length 변환할 길이
	 * @param pad 문자열 뒤에 추가할 byte
	 * @return str의 길이가 length보다 작을 경우 pad가 추가된 문자열. <br/>
	 * 	length보다 길면 원래문자열을 그대로 되돌린다.
	 */
	public static String stringPadding(String str, int length, byte pad) {
		if(str == null) return str;

		byte[] buf = str.getBytes();
		int len = buf.length;
		if(len >= length) return str;

		byte[] resBuf = new byte[length];
		System.arraycopy(buf, 0, resBuf, 0, len);
		byte[] padBytes = new byte[length-len];
		java.util.Arrays.fill(padBytes, pad);
		System.arraycopy(padBytes, 0, resBuf, len, padBytes.length);
		return new String(resBuf);
	}

	/**
	 * 원하는 길이만큼 표시한 후 ..을 붙임
	 *
	 * @param str 원 문자열
	 * @param byteSize 조정할 길이. byte 단위
	 * @return byteSize 길이로 조정된 문자열.
	 */
	public static String getShortString(String str, int byteSize) {
		return getShortString(str, byteSize, "..");
	}

	/**
	 * 원하는 길이만큼 표시한 후 tail을 붙임
	 *
	 * @param str 원 문자열
	 * @param byteSize 조정할 길이. byte 단위
	 * @param tail 붙일 문자열
	 * @return byteSize 길이로 조정된 문자열.
	 */
	public static String getShortString( String str, int byteSize , String tail) {
		int size = 0;
		int len = 0;

		if ( str.getBytes().length > byteSize ) {
			for ( ; size < str.length(); size++ ) {
				if ( str.charAt( size ) > 0x007F )
					len += 2;
				else
					len++;

				if ( len > byteSize )
					break;
			}
			str = str.substring( 0, size ) + tail;
		}
		return str;
	}

	/**
	 * 태그 리스트를 제한된 길이 단위의 태크 문자열로 변환한다.
	 *
	 * @param str 콤마(,)로 구분된 태그 리스트 문자열
	 * @param byteSize 문자열 제한 길이.
	 * @return 제한된 길이 단위의 태크 문자열로 변환한 문자열
	 */
	public static String getModifyString(String str,int byteSize){
		if (CommUtils.isEmpty(str)) return "";

		StringTokenizer st = new StringTokenizer(str,",");
		String[] registory = new String[5];
		String shottagname = "";
		int size =0;

		while(st.hasMoreTokens()){
			if (size < 5) {
				registory[size] = st.nextToken().trim();
				size++;
			}
			else break;
		}

		if(registory[0].length() < byteSize){
			for(int total = 0;total <= size ; total++){
				if(shottagname.length() < byteSize ){
					shottagname = shottagname.concat(registory[total]+",");
					if((shottagname+registory[total+1]).length() > byteSize){
						shottagname = shottagname.substring(0,shottagname.length()-1);
						break;
					}
				}
				else{
					break;
				}
			}
		}else{
			shottagname = registory[0];
		}
		return shottagname;
	}

	/**
	 * 요청된 URL 이 파라미터를 갖는지 여부 확인하여'?' or '&' 리턴한다.<br/>
	 * CASE 1 : xxxx.jsp            -> return '?'<br/>
	 * CASE 2 : xxxx.jsp?params=1   -> return '&'<br/>
	 * Written by mr.Ryu<br/>
	 * date : 2006.05.11<br/>
	 *
	 * @param sUrl URL 문자열
	 * @return 변환된 URL 문자열
	 */
	public static String getUrlParam( String sUrl ) {
		String returnStr = "?";
		String FIND_STR = "?";

		if( sUrl.indexOf( FIND_STR ) > -1 ){
			returnStr = "&";
		}

		return sUrl + returnStr;
	}

	/**
	 * Exception Stack trace를 문자열로 구한다.
	 *
	 * @param e Exception
	 * @return Exception stack trace를 문자열
	 */
	public static String getStackTraceAsString(Exception e) {
		ByteArrayOutputStream ostr = new ByteArrayOutputStream();
		e.printStackTrace(new PrintStream(ostr));
		return ostr.toString();
	}

	/**
	 * 현재 날짜를 주어진 필드 값을 증감하여 주어진 날짜 포맷 문자열로 변환한다.
	 *
	 * @param format 날짜 포맷
	 * @param field 설정 필드(MONTH, DATE, etc)
	 * @param offset 증감 값
	 * @return 주어진 날짜 포맷 문자열
	 */
	public static String getFormatDate(String format, int field, int offset) {

		final int rawOffset = 9 * 60 * 60 * 1000;
		SimpleTimeZone stz = new SimpleTimeZone(rawOffset, "KST");
		Calendar rightNow = Calendar.getInstance(stz);

		if (offset != 0) {
			rightNow.add(field, offset);
		}

		Date rightDate = rightNow.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		sdf.setTimeZone(stz);

		return	sdf.format(rightDate);
	}

	/**
	 * 현재 날짜의 일자를 주어진 offset만큼 증감하여 주어진 날짜 포맷 문자열로 변환한다.
	 *
	 * @param format 날짜 포맷
	 * @param offset 증감 값
	 * @return 주어진 날짜 포맷 문자열
	 */
	public static String getDateAdd2(String format, int offset) {
		return getFormatDate(format, Calendar.DATE, offset);
	}

	/**
	 * 현재 날짜의 일자를 주어진 offset만큼 증감하여 yyyyMMdd 포맷 문자열로 변환한다.
	 *
	 * @param offset 설정 위치
	 * @return yyyyMMdd 포맷 문자열
	 */
	public static String getDateAdd(int offset) {
		return getFormatDate("yyyyMMdd", Calendar.DATE, offset);
	}

	/**
	 * 현재 날짜의 월을 주어진 offset 만큼 증감하여 yyyyMMdd 포맷 문자열로 변환
	 * @param offset 증감 값
	 * @return yyyyMMdd 포맷 문자열
	 */
	public static String getMonthAdd(int offset) {
		return getFormatDate("yyyyMMdd", Calendar.MONTH, offset);
	}

	/**
	 * 현재 날짜의 년을 주어진 offset 만큼 증감하여 yyyyMMdd 포맷 문자열로 변환
	 * @param offset 증감 값
	 * @return yyyyMMdd 포맷 문자열
	 */
	public static String getYearAdd(int offset) {
		return getFormatDate("yyyyMMdd", Calendar.YEAR, offset);
	}

	/**
	 * Date를 포멧된 문자열로 변환한다.
	 *
	 * @param date 날짜. Date Object
	 * @param format 날짜 포멧
	 * @return 포멧된 날짜
	 */
	public static String getDateString(Date date, String format) {
		TimeZone tz = TimeZone.getDefault();
		TimeZone.setDefault(tz);
		SimpleDateFormat df = new SimpleDateFormat(format);
		String dateStr  = df.format(date);
		return dateStr;
	}

	/**
	 * 주어진 문자열을 숫자로 변환하여 +1 증가시킨 후 주어진 길이의 문자열로 재변환한다.
	 *
	 * @param str 주어진 문자열
	 * @param len 되돌릴 문자열 길이.
	 * @return 증가된 문자열
	 */
	public static String nextNumStr(String str, int len) {
		int no = Integer.parseInt(str);
		no++;
		byte[] tmp = String.valueOf(no).getBytes();

		byte[] buf = new byte[len];
		Arrays.fill(buf, (byte)'0');

		System.arraycopy(tmp, 0, buf, len-tmp.length, tmp.length);
		return new String(buf);
	}

	/**
	 * 주어진 파일리스트를 파일 생성 날짜 기준으로 정렬한다.
	 *
	 * @param file 파일 array
	 * @param asc 내림차순(false)/오름차순(true)
	 * @return 정렬된 file list
	 */
	public static File[] sort(File[] file, boolean asc) {
		if(asc) return sort(file);
		else return sortDesc(file);
	}

	/**
	 * 주어진 파일리스트를 파일 생성 날짜 기준으로 오름 차순으로 정렬한다.
	 * @param file 파일 array
	 * @return 정렬된 file list
	 */
	public static File[] sort(File[] file) {
		File buff;
		for(int i = 0; i < file.length; i++) {
			for(int j = i + 1; j < file.length; j++) {
				if(file[i].lastModified() > file[j].lastModified()) {
					buff = file[i];
					file[i] = file[j];
					file[j] = buff;
				}
			}
		}
		return file;
	}

	/**
	 * 주어진 파일리스트를 파일 생성 날짜 기준으로 내림 차순으로 정렬한다.
	 * @param file 파일 array
	 * @return 정렬된 file list
	 */
	public static File[] sortDesc(File[] file) {
		File buff;
		for(int i = 0; i < file.length; i++) {
			for(int j = i + 1; j < file.length; j++) {
				if(file[i].lastModified() < file[j].lastModified()) {
					buff = file[i];
					file[i] = file[j];
					file[j] = buff;
				}
			}
		}
		return file;
	}

	/**
	 * 주어진 파일 리스트를 이름 순으로 정렬한다.
	 *
	 * @param file 파일 리스트
	 * @param asc 오름차순(true), 내림차순(false)
	 * @return 정렬된 파일 리스트
	 */
	public static File[] sortByName(File[] file, boolean asc) {
		if(asc) {
			return sortByName(file);
		} else {
			File buff;
			for(int i = 0; i < file.length; i++) {
				for(int j = i + 1; j < file.length; j++) {
					if(file[i].getName().compareTo(file[j].getName()) < 0) {
						buff = file[i];
						file[i] = file[j];
						file[j] = buff;
					}
				}
			}
			return file;
		}
	}

	/**
	 * 주어진 파일 리스트를 이름 순으로 오름차순 정렬한다.
	 *
	 * @param file 파일 리스트
	 * @return 정렬된 파일 리스트
	 */
	public static File[] sortByName(File[] file) {
		File buff;
		for(int i = 0; i < file.length; i++) {
			for(int j = i + 1; j < file.length; j++) {
				if(file[i].getName().compareTo(file[j].getName()) > 0) {
					buff = file[i];
					file[i] = file[j];
					file[j] = buff;
				}
			}
		}
		return file;
	}

	/**
	 * 주어진 문자열 리스트를 이름 순으로 정렬한다.
	 *
	 * @param str 파일 리스트
	 * @return 정렬된 문자열 리스트
	 */
	public static String[] sort(String[] str) {
		String buff;
		for(int i = 0; i < str.length; i++) {
			for(int j = i + 1; j < str.length; j++) {
				if(str[i].compareTo(str[j]) > 0) {
					buff = str[i];
					str[i] = str[j];
					str[j] = buff;
				}
			}
		}
		return str;
	}

	/**
	 * 주어진 디렉터리 내에서 유니크한 파일명을 생성한다.
	 *
	 * @param dir 주어진 디렉터리
	 * @param ext 파일 확장자
	 * @return 유니크한 파일명
	 */
	public static String makeUniqueFileName(String dir, String ext) {
		File baseDir = new File(dir);
		if(!baseDir.exists()) {
			if(!baseDir.mkdirs()) {
				return null;
			}
		}
		return makeUniqueFileName(baseDir, ext);
	}
	/**
	 * 주어진 디렉터리 내에서 유니크한 파일명을 생성한다.
	 *
	 * @param dir 주어진 디렉터리. File 객체
	 * @param ext 파일 확장자
	 * @return 유니크한 파일명
	 */
	public static String makeUniqueFileName(File dir, String ext) {
		String fname = null;
		do {
			if(fname != null) {
				try { Thread.sleep(100); } catch(Exception e) {}
			}
			// 2007.11.06, rainman
			fname = String.valueOf(System.currentTimeMillis())+"."+ext;
			// WAP이미지의 경우 파일명+"_wap"+".png" 형태로 변환되므로 최대 길이 20byte를
			// 초과하지 않도록 하기 위해 파일명의 최대 길이는 확장자 포함 16자를 넘지 말아야 함.
			// IMG_TB의 WEB_IMG, WAP_176 등 필드의 길이는 20임.
			int len = fname.length();
			if(len > 16) fname = fname.substring(len-16);
		} while(new File(dir, fname).exists());

		return fname;

	}

	/**
	 * 사용되지 않음.
	 * @deprecated
	 * @param dir 상위 폴더
	 * @param uid 사용자 ID
	 * @param ext 파일 확장자.
	 * @return 파일명
	 */
	public static String makeUniqueFileName(String dir, String uid, String ext) {
		File userDir = new File(dir, uid);
		// 사용자 디렉터리는 없으면 만들어 준다.
		if(!userDir.exists()) {
			if(!userDir.mkdirs()) {
				return null;
			}
		}
		return CommUtils.makeUniqueFileName(userDir.getAbsolutePath(), ext);
	}

	/**
	 * GET NUMBER OF DAYS IN MONTH
	 *
	 * @param year 년도
	 * @param month 월
	 * @return 일수
	 */
	public static int getDaysInMonth(int year, int month)  {
		int days = 30;
		if(month==1 || month==3 || month==5
				|| month==7 || month==8
				|| month==10 || month==12) {
			days=31;
		} else if(month==4 || month==6 || month==9 || month==11) {
			days=30;
		} else if(month==2)  {
			if(isLeapYear(year)) {
				days=29;
			} else {
				days=28;
			}
		}
		return (days);
	}

	/**
	 * CHECK TO SEE IF YEAR IS A LEAP YEAR
	 * @param Year
	 * @return 윤년이면 true
	 */
	public static boolean isLeapYear(int Year) {
		if(((Year % 4)==0) && ((Year % 100)!=0) || ((Year % 400)==0)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 주어진 날짜의 일을 n 증가시킨 값을 yyyyMMdd 포맷 문자열로 변환한다.
	 *
	 * @param date java.util.Date 객체
	 * @param n 증감 값
	 * @return yyyyMMdd 포맷 문자열
	 */
	public static String getDate(Date date, int n) {
		return getDate(date, n, "yyyyMMdd");
	}

	/**
	 * 주어진 날짜의 일을 n 증가시킨 값을 주어진 포맷 문자열로 변환한다.
	 *
	 * @param date java.util.Date 객체
	 * @param n 증감 값
	 * @param format 주어진 포맷. 예) yyyyMMdd
	 * @return 포맷 문자열
	 */
	public static String getDate(Date date, int n, String format) {
		try {
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(format);
			java.util.Calendar cal = java.util.Calendar.getInstance();
			cal.setTime(date);
			cal.add(java.util.Calendar.DATE, n);
			return sdf.format(cal.getTime());
		} catch(Exception e) {
			return null;
		}
	}

	/**
	 * 주어진 날짜 문자열(yyyyMMdd 형태여야 함)의 일을 n 증가시킨 값을 주어진 포맷 문자열로 변환한다.
	 *
	 * @param date yyyyMMdd 형태의 문자열
	 * @param n 증감 값
	 * @return 포맷 문자열
	 */
	public static String getDate(String date, int n) {
		try {
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyyMMdd");
			java.util.Calendar cal = java.util.Calendar.getInstance();
			cal.setTime(sdf.parse(date));
			cal.add(java.util.Calendar.DATE, n);
			return sdf.format(cal.getTime());
		} catch(Exception e) {
			return date;
		}
	}

	/**
	 * yyyyMM 형식의 문자열의 월을 n 만큼 증감 시켜 yyyyMM 형식으로 되돌린다.
	 *
	 * @param month yyyyMM 형식의 문자열
	 * @param n 증감 값
	 * @return yyyyMM 형식 문자열
	 */
	public static String getMonth(String month, int n) {
		try {
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyyMM");
			java.util.Calendar cal = java.util.Calendar.getInstance();
			cal.setTime(sdf.parse(month));
			cal.add(java.util.Calendar.MONTH, n);
			return sdf.format(cal.getTime());
		} catch(Exception e) {
			return month;
		}
	}

	/**
	 * yyyy 형식의 문자열의 년을 n 만큼 증감 시켜 yyyy 형식으로 되돌린다.
	 *
	 * @param year yyyy형식의 문자열
	 * @param n 증감 값
	 * @return yyyy형식의 문자열
	 */
	public static String getYear(String year, int n) {
		try {
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy");
			java.util.Calendar cal = java.util.Calendar.getInstance();
			cal.setTime(sdf.parse(year));
			cal.add(java.util.Calendar.YEAR, n);
			return sdf.format(cal.getTime());
		} catch(Exception e) {
			return year;
		}
	}

	/**
	 * 주어진 문자열을 특정한 형식으로 포멧된 문자열로 바꾼다.
	 * 포멧 tag는 # 기호를 사용한다.
	 *
	 * @param str 변환할 원문 문자열
	 * @param format 변환된 문자열 포멧
	 * @return 변환된 문자열
	 */
	public static String format(String str, String format) {
		if(str == null) return str;

		char ch;
		int off = 0;
		StringBuffer sb = new StringBuffer();
		try {
			for(int i = 0;;i++) {
				ch = format.charAt(i);
				if(ch == '#') sb.append(str.charAt(off++));
				else sb.append(ch);
			}
		} catch(StringIndexOutOfBoundsException e) {}
		return sb.toString();
	}

	/**
	 * 주어진 문자열을 Date Object로 변환
	 *
	 * @param dateStr 날짜 문자열
	 * @param format 날짜 포멧
	 * @return Date Object
	 */
	public static Date parseDate(String dateStr, String format) {
		if(dateStr == null) return null;
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		ParsePosition ps = new ParsePosition(0);
		Date date = formatter.parse(dateStr, ps);
		return date;
	}
	
	/**
	 * 인자값으로 받은 날짜에 해당하는 그 주의 첫번째 날을 format에 맞게 변환하여 문자열로 리턴.
	 * 
	 * 예) date : 2011-07-06, format : yyyy-MM-dd,  returnValue : "2011-07-03"
	 * 
	 * @param date 해당 날짜
	 * @param format 날짜 포멧
	 * @return
	 */
	public static String getFirstDateOfWeek(Date date, String format){
		
		if(date == null) return "";
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		cal.add(Calendar.DAY_OF_WEEK, cal.getActualMinimum(Calendar.DAY_OF_WEEK) - cal.get(Calendar.DAY_OF_WEEK) );
		
		return formatDate(cal.getTime(), format);
	}
	
	/**
	 * 인자값으로 받은 날짜에 해당하는 그 주의 마지막 날을 format에 맞게 변환하여 문자열로 리턴.
	 * 
	 * 예) date : 2011-07-06, format : yyyy-MM-dd,  returnValue : "2011-07-09"
	 * 
	 * @param date 해당 날짜
	 * @param format 날짜 포멧
	 * @return
	 */
	public static String getLastDateOfWeek(Date date, String format){
		
		if(date == null) return "";
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		cal.add(Calendar.DAY_OF_WEEK, cal.getActualMaximum(Calendar.DAY_OF_WEEK) - cal.get(Calendar.DAY_OF_WEEK) );
		
		return formatDate(cal.getTime(), format);
	}

	/**
	 * 영문이면 True
	 *
	 * @param str 체크할 문자열
	 * @return 영문이면 true
	 */
	public static boolean isAlpha(char str){
		return   ((str >= 'a' && str <= 'z') || ( str >= 'A' && str <= 'Z' )) ? true:false;
	}

	/**
	 * 주어진 size 값을 크기에 따라 MB, KB, byte 기호를 추가한다.
	 * @param size Size
	 * @return 기호가 붙은 문자열
	 */
	public static String makeKByteSize(int size) {

		String s;
		if(size >= 1000000) {
			int mod = size % 10000;
			if(mod < 5000) size -= mod;
			else size += 10000 - mod;
			s = (float)(size/1000000.0f)+"MB";
		} else if(size >= 1000) {
			int mod = size % 10;
			if(mod < 5)	size -= mod;
			else size += 10 - mod;
			s = (float)(size/1000.0f) + "KB";
		} else {
			s = size + "Byte";
		}
		return s;
	}

	/**
	 * 주어진 값을 크기에 따라 MB, KB, byte 기호를 추가한다.
	 * @param str Size 문자열
	 * @return 기호가 붙은 문자열
	 */
	public static String makeKByteSize(String str) {
		if(str == null) return "";
		try {
			return makeKByteSize(Integer.parseInt(str));
		} catch(Exception e) {
			return str+"Byte";
		}
	}

	/**
	 * 현재시간과 주어진 시간(regDate)와의 시간 갭을 구한다.<br/>
	 * 2분전: 방금, 한시간전: 00분전, 24시간전: 00시간 전, 3일전: 하루 전, 이틀전, 3일전 형식
	 *
	 * @param regDate 주어진 시간
	 * @return 현재시간과 주어진 시간(regDate)와의 시간 갭
	 */
	public static String getCustomRegDate(String regDate) {
		long curTime = System.currentTimeMillis();
		return getCustomRegDate(curTime, regDate);
	}

	/**
	 * 게시물 등이 등록된 날짜가 얼마나 지났는지를 표시하는 문자열을 반환한다.<br/>
	 * 2분전: 방금, 한시간전: 00분전, 24시간전: 00시간 전, 3일전: 하루 전, 이틀전, 3일전 형식
	 * @param curTime 비교할 long type 시간.
	 * @param regDate 등록 시간
	 * @return 현재시간과 주어진 시간(regDate)와의 시간 갭
	 */
	public static String getCustomRegDate(long curTime, String regDate) {
		String custStr = regDate;
		try {
			java.util.Date d = CommUtils.parseDate(regDate, "yyyy-MM-dd HH:mm:ss");
			long upTime = d.getTime();
			long gap = curTime-upTime;
			if(gap < 1000*60*2) custStr ="방금";
			else if(gap < 1000*60*60) {
				long t = gap/(1000*60);
				custStr = (t+"분 전");
			} else if(gap < 1000*60*60*24) {
				long t = gap/(1000*60*60);
				custStr = (t+"시간 전");
			} else if(gap < 1000*60*60*24*3) {
				long t = gap/(1000*60*60*24);
				if(t == 1) custStr = ("하루 전");
				else if(t == 2) custStr = ("이틀 전");
				else custStr = (t+"일 전");
			}
		} catch(Exception ex) {
		}
		return custStr;
	}

	/**
	 * 파일 확장자를 구한다.
	 * @param fname 파일명
	 * @return 확장자.
	 */
	public static String getFileExt(String fname) {
		String ext = "";
		int off = fname.lastIndexOf(".");
		if(off != -1 && off < fname.length()) {
			ext = fname.substring(off+1).toLowerCase();
		}
		return ext;
	}

	/**
	 * 확장자를 제외한 파일명 문자열을 구한다.
	 *
	 * @param file File 객체
	 * @return 확장자를 제외한 파일명 문자열
	 */
	public static String getFileName(File file) {
		return getFileName(file.getName());
	}

	/**
	 * 확장자를 제외한 파일명 문자열을 구한다.
	 *
	 * @param fileName 파일명
	 * @return 확장자를 제외한 파일명 문자열
	 */
	public static String getFileName(String fileName) {
		int off = fileName.indexOf(".");
		if(off != -1) return fileName.substring(0, off);
		return fileName;
	}

	/**
	 * 파일 확장자를 구한다.
	 * @param file File 객체
	 * @return 확장자
	 */
	public static String getFileExt(File file) {
		return getFileExt(file.getName());
	}

	/**
	 * 사용하지 않음.
	 *
	 * @deprecated
	 * @see CommUtils.makeUniqueFileName(File src, File dst);
	 * @param src 원본
	 * @param dst 대상
	 * @return 파일명
	 */
	public static String generateFileName(File src, File dst) {
		if(dst.exists()) {
			String path = dst.getParent();
			String fn = dst.getName();
//			fn = CommUtils.generateFileName(path, CommUtils.getFileExt(fn));
			fn = CommUtils.makeUniqueFileName(path, CommUtils.getFileExt(fn));
			dst = new File(path, fn);
		}
		return dst.getName();
	}
	/**
	 * 유니크 파일명 생성
	 * @param dst 대상 파일
	 * @return 파일명
	 */
	public static String makeUniqueFileName(File dst) {
		if(dst.exists()) {
			String path = dst.getParent();
			String fn = dst.getName();
			fn = CommUtils.makeUniqueFileName(path, CommUtils.getFileExt(fn));
			dst = new File(path, fn);
		}
		return dst.getName();
	}

	/**
	 * src 파일을 dst파일로 rename시킨다.
	 * 이때 dst파일이 이미 존재하면 새로운 파일명으로 파일을 생성하고 파일명을 반환한다.
	 *
	 * @param src 원본 파일 객체
	 * @param dst 대상 파일 객체
	 * @return file name
	 */
	public static String createFile(File src, File dst) {
		return createFile(src, dst, false);
	}
	/**
	 * 파일 생성
	 * @param src 원본 파일 객체
	 * @param dst 대상 파일 객체
	 * @param overwrite 대상 파일이 있을 경우 덮어 쓸지 여부,true면 덮어 쓴다.
	 * @return
	 */
	public static String createFile(File src, File dst, boolean overwrite) {
		if(!overwrite && dst.exists()) {
			String path = dst.getParent();
			String fn = dst.getName();
			fn = CommUtils.makeUniqueFileName(path, CommUtils.getFileExt(fn));
			dst = new File(path, fn);
		}
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(src);
			fos = new FileOutputStream(dst);
			byte[] buf = new byte[2048];
			int len = 0;
			while((len = fis.read(buf)) != -1) {
				fos.write(buf, 0, len);
			}
		} catch(Exception e) {
//			e.printStackTrace();
		} finally {
			if(fis != null) {
				try { fis.close(); } catch(Exception e) {}
			}
			if(fos != null) {
				try { fos.close(); } catch(Exception e) {}
			}
		}
		return dst.getName();
	}

	/**
	 * 빈문자열(null이거나 공백문자열)인지 확인한다.
	 *
	 * @param str 체크할 문자열
	 * @return 빈문자열(null이거나 공백문자열)이면 true
	 */
	public static boolean isEmpty(String str) {
		return (str == null || str.trim().length() == 0);
	}

	/**
	 * WAP 글보기에서 DB에서 문자가 변경된 부분에 대해서 HTML 코드를 없애고 <br/> 태그를 추가해
	 * 08.05.21 생성 kihyun...
	 * @param str html code
	 * @return 변환된 문자열

	public static String replaceHtml(String str){
		if(str != null){
			str = str.replaceAll("</p>", "<br/>");
			str = str.replaceAll("<br />", "<br/>");
			str = str.replaceAll("<P>", "");
			str = str.replaceAll("<p>", "");
		}
		String[] result = str.split("<br/>");

		String[] splitngc = new String[result.length];
		String txt = "";

		for(int i=0;i < result.length ; i++){
			splitngc[i] = convertHtml2Text2(result[i]);
			if(!splitngc[i].equals("")){
				txt = txt + splitngc[i] + "<br/>";
			}
		}
		if(txt.endsWith("<br/>")){
			txt = txt.substring(0,txt.length()-5);
		}
		return txt;
	}

	/**
	 * html code 제거.
	 *
	 * @param str 원본 문자열
	 * @return 변환된 문자열
	 */
	public static String replacengc(String str){
		String buf      = null;
		String subMsg   = "";
		buf = str;

		buf = replaceString(buf, "<p>", "");
		buf = replaceString(buf, "</p>", "");
		buf = replaceString(buf, "</a>", "");

		int startIdx = 0;
		int endIdx   = 0;

		while( ( startIdx = buf.indexOf("<a href") ) > -1 ){
			endIdx   = buf.indexOf("\">");

			subMsg  = buf.substring(startIdx, endIdx+2);
			buf 	= replaceString(buf, subMsg, "");
		}
		return buf;
	}

	/**
	 * cookie domain 구하기.
	 *
	 * @param serverName 서버명
	 * @return cookie domain
	 */
	public static String getCookieDomain(String serverName) {
		try {
			java.util.StringTokenizer st = new java.util.StringTokenizer(serverName, ".");
			int tok = st.countTokens();
			if(tok < 3) return serverName;

			for(int i = 0; i < tok-2; i++) {
				st.nextElement();
			}
			StringBuffer buf = new StringBuffer();
			while(st.hasMoreTokens()) {
				buf.append(st.nextToken()).append(".");
			}
			String domain = buf.toString();
			if(domain.endsWith(".")) domain = domain.substring(0, domain.length()-1);
			return domain;
		} catch(Exception e) {
			return null;
		}
	}


	/**
	 * html code 문자열을 일반 문자열로 변환
	 * @param html html code 문자열
	 * @return 일반 문자열

	public static String convertHtml2Text(String html) {
		String txt = "";
		try {
			Parser parser = new Parser();
			parser.setInputHTML(html);

			NodeList nl = parser.parse(null);
			txt = StringUtils.replaceHtmlToText(nl.asString());
		} catch(Exception e) {
		}
		return txt;
	}
	 */
	/**
	 * 왑 글보기 용 문자열 변환
	 * @param txt 원본 문자열
	 * @return 변환된 문자열
	 */
	public static String toWapContent(String txt) {
		if(txt != null) {
			txt = txt.replaceAll("<", "&lt;");
			txt = txt.replaceAll(">", "&gt;");
			txt = txt.replaceAll("\"","&quot;");
		}
		return txt;
	}

	/**
	 * WAP 글보기에서 HTML 코드를 없애주기 위한 WAP METHOD
	 * 08.05.21 생성 kihyun...
	 * @param str 체크할 문자열
	 * @return 변환된 문자열

	public static String convertHtml2Text2(String html) {
		String txt = "";
		try {
			Parser parser = new Parser();
			parser.setInputHTML(html);

			NodeList nl = parser.parse(null);
			txt = nl.asString();
		} catch(Exception e) {
//			e.printStackTrace();
		}
		return txt;
	}
	/**
	 * HTML에서 SCRIPT TAG를 제거하는 Method.
	 *
	 * @param html 체크할 html code 문자열
	 * @return 스크립트 코드가 제거된 html code 문자열
	 */
	public static String removeScriptTag(String html) {
		String regEx = "<(script*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>([^<]*)</(script*)?(\\s)*>";
		java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regEx,
				java.util.regex.Pattern.CASE_INSENSITIVE |
				java.util.regex.Pattern.DOTALL |
				java.util.regex.Pattern.MULTILINE);
		java.util.regex.Matcher matcher = pattern.matcher(html);
		return matcher.replaceAll("");
//		return html.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
	}
	
	/**
	 * HTML 태그를 모두 제거
	 * @param html 
	 * @return HTML태그가 제거된 문자열
	 */
	public static String removeHtmlTag(String html) {
		String regEx = "<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>";
		java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regEx,
				java.util.regex.Pattern.CASE_INSENSITIVE |
				java.util.regex.Pattern.DOTALL |
				java.util.regex.Pattern.MULTILINE);
		java.util.regex.Matcher matcher = pattern.matcher(html);
		return matcher.replaceAll("");
	}

	/**
	 * 파일 복사
	 * @param src 원본 파일 경로
	 * @param dst 대상 파일 경로
	 * @throws Exception
	 */
	public static void copyFile(String src, String dst) throws Exception {
		copyFile(new FileInputStream(src), new FileOutputStream(dst));
	}
	/**
	 * 파일 복사
	 * @param src 원본 파일 객체
	 * @param dst 대상 파일 객체
	 * @throws Exception
	 */
	public static void copyFile(File src, File dst) throws Exception {
		copyFile(new FileInputStream(src), new FileOutputStream(dst));
	}

	/**
	 * 파일 복사
	 * @param in 원본 파일 inputstream
	 * @param out 대살 파일 outputstream
	 * @throws Exception
	 */
	public static void copyFile(InputStream in, OutputStream out) throws Exception {
		byte[] buf = new byte[2048];
		int len = 0;
		while((len = in.read(buf)) != -1) {
			out.write(buf, 0, len);
		}
		in.close();
		out.close();
	}

	/**
	 * Get MD5
	 * @param org 원본 문자열.
	 * @return MD5 문자열
	 * @throws Exception
	 */
	public static String getMD5 ( String org ) throws Exception
	{
		MessageDigest md = MessageDigest.getInstance( "MD5" );
		md.update( org.getBytes() );
		byte [] orgByte = md.digest();

		StringBuffer sb = new StringBuffer();
		for ( int i = 0 ; i < orgByte.length ; i++ )
		{
			sb.append( orgByte[i] );
		}

		String digested = sb.toString();
		digested = digested.replaceAll( "-", "" );

		return digested;
	}

	/**
	 * MD5로 변환한 문자열의 hex byte를 구한다.
	 *
	 * @param str 원본 문자열
	 * @return MD5로 변환한 문자열의 hex byte 문자열
	 * @throws Exception
	 */
	public static String getMD5Hash ( String str ) throws Exception
	{
		MessageDigest md = MessageDigest.getInstance( "MD5" );
		md.update( str.getBytes() );
		byte[] b = md.digest();
		return HexUtils.toHexByte(b);
	}

	/**
	 * ngc specific routine -- check id is valid (20 bytes, number)
	 * @param str 체크할 문자열
	 * @return 주어진 문자열이 숫자로만 구성되었으면 true
	 */
	public static boolean isNum(String str){
		if (null == str) return false;
		if (str.length() == 0) return false;

		char  c;
		for (int i=0; i<str.length(); i++) {
			c = str.charAt(i);
			if (c < '0' || c > '9') return false;
		}
		return true;
	}

	/**
	 * 주어진 도메인에 port가 붙어 있을 경우 제거한 값을 되돌린다.
	 *
	 * @param domain 체크할 도메인
	 * @return port가 붙어 있을 경우 제거한 값, 없으면 그대로...
	 */
	public static String getDomainOnly(String domain) {
		int idx = domain.indexOf(":");
		if(idx != -1) {
			domain = domain.substring(0, idx);
		}

		return domain;
	}

	/**
	 * 주어진 url로부터 호스트명을 구한다.
	 *
	 * @param url 체크할 url
	 * @return 호스트명
	 */
	public static String getHostnameFromUrl(String url) {
		if(url == null) return null;

		String prefix = "http://";
		String str = url.toLowerCase().trim();
		if(!str.startsWith(prefix)) return null;

		int off1 = prefix.length();
		int off2 = str.indexOf(".", off1);
		if(off2 == -1) return null;

		return str.substring(off1, off2);
	}

	/**
	 * convert YYYYMMDD to RRRR-MM-DD HH24:MI:SS
	 * @param ymd String of YYYYMMDD
	 * @return  String for start of day.
	 */
	public static String convYmd( String ymd ) {
		return convYmd( ymd, 0 );
	}

	 /**
	 * convert YYYYMMDD to RRRR-MM-DD HH24:MI:SS
	 * @param ymd String of YYYYMMDD
	 * @param type =0 for start of day, =1 for end of day
	 */
	public static String convYmd( String ymd, int type ) {
		String y, m, d;
		int		len;
		if (null == ymd) return null;

		len = ymd.length();

		if (len>= 8) d = ymd.substring(6, 8);
		else d = "00";

		if (len >= 6 )  m = ymd.substring(4,6);
		else  m = "00";

		if (len >= 4) y = ymd.substring(0,4);
		else y = "0000";

		if (0 == type) return y + "-" + m + "-" + d + " 00:00:00";
		return y + "-" + m + "-" + d + " 23:59:59";
	}

	/**
	 * 패키지 명을 제외한 클래스 명을 구한다.<br/>
	 *
	 * @param c Class 객체
	 * @return 패키지 명을 제외한 클래스 명
	 */
	public static String getClassName(Class c) {
		String cname = c.getName();
		if(cname != null) {
			int off = cname.lastIndexOf(".");
			if(off != -1) cname = cname.substring(off+1);
		}
		return cname;
	}

	/**
	 * 패키지 명을 제외한 클래스 명을 구한다.<br/>
	 * @param obj Object 객체
	 * @return 패키지 명을 제외한 클래스 명
	 */
	public static String getClassName(Object obj) {
		String cname = obj.getClass().getName();
		if(cname != null) {
			int off = cname.lastIndexOf(".");
			if(off != -1) cname = cname.substring(off+1);
		}
		return cname;
	}
	
	/**
	 * 문자열의 byte 길이를 구한다.
	 * @param str
	 * @return byte길이
	 */
	public static int getByteLength(String str) {
		str = CommUtils.checkNull(str);
		int length = 0;
		
		for(int i=0; i<str.length(); i++){
			if(str.charAt(i) > 0x007F){
				length += 2;
			}
			else{
				length++;
			}
		}
		
		return length;
	}
}
