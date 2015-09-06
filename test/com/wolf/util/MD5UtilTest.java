package com.wolf.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * author lzc
 */
public class MD5UtilTest {

	@Before
	public void setUp() throws Exception {
		MD5Util md5Util = new MD5Util();
		md5Util.MD5("1");
	}

	@Test
	public void testMD5() {
		assertEquals("C4CA4238A0B923820DCC509A6F7584B", MD5Util.MD5("1"));
		
//		fail("Not yet implemented");
	}

}
