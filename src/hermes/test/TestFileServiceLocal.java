package hermes.test;

import static org.junit.Assert.*;
import hermes.services.FileServiceLocal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestFileServiceLocal {
	FileServiceLocal local;
	
	@Before
	public void setUp() throws Exception {
		local = new FileServiceLocal();
	}

	@After
	public void tearDown() throws Exception {
		local = null;
	}

	@Test
	public void testNullGetHashStringForFile() {
		assertEquals("testNullGetHashStringForFile: ", local.getHashStringForFile(null), "");
	}
	

}
