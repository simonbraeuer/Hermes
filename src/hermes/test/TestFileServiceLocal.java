package hermes.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import hermes.services.FileServiceLocal;

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
