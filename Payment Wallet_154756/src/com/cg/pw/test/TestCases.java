package com.cg.pw.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cg.pw.UI.*;
import com.cg.pw.dao.AccountDaoImpl;
import com.cg.pw.exception.*;
import com.cg.pw.service.*;

public class TestCases {

	AccountServiceImpl obj = new AccountServiceImpl();
	MainUI obj1 = new MainUI();

	@Test
	public void testValidateMobileNumber() {
		String t = "false";
		try {
			obj.validateMobileNumber("242356");
		} catch (InvalidMobileNumber e) {
			t = "true";
		}
		assertEquals("true", t);
	}

	@Test
	public void testValidateMobileNumber1() {
		String t = "false";
		try {
			obj.validateMobileNumber("9728433037");
		} catch (InvalidMobileNumber e) {
			t = "true";
		}
		assertEquals("false", t);
	}

	@Test
	public void testDuplicateMobileNumber() {
		String t = "false";
		try {
			obj.validateDuplicateEntry("8295153490");
		} catch (DuplicateMobileNumber e) {
			t = "true";
		}
		assertEquals("true", t);
	}

	@Test
	public void testDuplicateMobileNumber1() {
		String t = "false";
		try {
			obj.validateDuplicateEntry("9728433037");
		} catch (DuplicateMobileNumber e) {
			t = "true";
		}
		assertEquals("false", t);
	}

	@Test
	public void testSearchAccount() {
		String t = "false";
		try {
			obj.searchAccount("8295153490");
		} catch (UserExceptions e) {
			t = "true";
		}
		assertEquals("false", t);
	}

	@Test
	public void testSearchAccount1() {
		String t = "false";
		try {
			obj.searchAccount("8295153499");
		} catch (UserExceptions e) {
			t = "true";
		}
		assertEquals("true", t);
	}

	@Test
	public void testMatchPassword() {
		String t = "false";
		try {
			obj.matchPassword("8295153490", "qwertyuiop");
		} catch (UserExceptions e) {
			t = "true";
		}
		assertEquals("false", t);
	}

	@Test
	public void testMatchPassword1() {
		String t = "false";
		try {
			obj.matchPassword("8295153490", "qwerty");
		} catch (UserExceptions e) {
			t = "true";
		}
		assertEquals("true", t);
	}

	@Test
	public void testcheckWithdrawAmount() {
		String t = "false";
		try {
			obj.checkWithdrawAmount("8295153490", 501);
		} catch (NotEnoughBalance | NotValidAmount e) {
			t = "true";
		}
		assertEquals("true", t);
	}

	@Test
	public void testcheckWithdrawAmount1() {
		String t = "false";
		try {
			obj.checkWithdrawAmount("8295153490", 500);
		} catch (NotEnoughBalance | NotValidAmount e) {
			t = "true";
		}
		assertEquals("false", t);
	}

	@Test
	public void testcheckWithdrawAmount2() {
		String t = "false";
		try {
			obj.checkWithdrawAmount("8295153490", 499);
		} catch (NotEnoughBalance | NotValidAmount e) {
			t = "true";
		}
		assertEquals("false", t);
	}

	@Test
	public void testcheckWithdrawAmount3() {
		String t = "false";
		try {
			obj.checkWithdrawAmount("8295153490", 0);
		} catch (NotEnoughBalance | NotValidAmount e) {
			t = "true";
		}
		assertEquals("true", t);
	}

	@Test
	public void testcheckWithdrawAmount4() {
		String t = "false";
		try {
			obj.checkWithdrawAmount("8295153490", -6);
		} catch (NotEnoughBalance | NotValidAmount e) {
			t = "true";
		}
		assertEquals("true", t);
	}

	@Test
	public void testShowBalance() {
		String t = "false";
		obj.showBalance("8295153490");
		if (AccountDaoImpl.accountEntry.get("8295153490").getBalance("8295153490") == 500)
			t = "true";

		assertEquals("true", t);
	}

	@Test
	public void testShowBalance1() {
		String t = "false";
		obj.showBalance("8295153490");
		if (AccountDaoImpl.accountEntry.get("8295153490").getBalance("8295153490") != 500)
			t = "true";

		assertEquals("false", t);
	}

	@Test
	public void testDeposit() {
		String t = "false";
		obj.deposit("8295153490", (double) 100);
		if (AccountDaoImpl.accountEntry.get("8295153490").getBalance("8295153490") == 600)
			t = "true";

		assertEquals("true", t);
	}

	@Test
	public void testDeposit1() {
		String t = "false";
		obj.deposit("8295153490", (double) 100);
		if (AccountDaoImpl.accountEntry.get("8295153490").getBalance("8295153490") != 600)
			t = "true";

		assertEquals("false", t);
	}

	@Test
	public void testWithdraw() {
		String t = "false";
		obj.withdraw("8295153490", (double) 100);
		if (AccountDaoImpl.accountEntry.get("8295153490").getBalance("8295153490") == 400)
			t = "true";

		assertEquals("true", t);
	}

	@Test
	public void testWithdraw1() {
		String t = "false";
		obj.withdraw("8295153490", (double) 100);
		if (AccountDaoImpl.accountEntry.get("8295153490").getBalance("8295153490") != 400)
			t = "true";

		assertEquals("false", t);
	}

	@Test
	public void testTransfer() {
		String t = "false";
		obj.transfer("8295153490", "9973952350", 200);
		if ((AccountDaoImpl.accountEntry.get("8295153490").getBalance("8295153490") == 300)
				&& (AccountDaoImpl.accountEntry.get("9973952350").getBalance("9973952350") == 400))
			t = "true";

		assertEquals("true", t);
	}

	@Test
	public void testTransfer1() {
		String t = "false";
		obj.transfer("8295153490", "9973952350", 200);
		if ((AccountDaoImpl.accountEntry.get("8295153490").getBalance("8295153490") == 300)
				&& (AccountDaoImpl.accountEntry.get("9973952350").getBalance("9973952350") != 400))
			t = "true";

		assertEquals("false", t);
	}

	@Test
	public void testTransfer2() {
		String t = "false";
		obj.transfer("8295153490", "9973952350", 200);
		if ((AccountDaoImpl.accountEntry.get("8295153490").getBalance("8295153490") != 300)
				&& (AccountDaoImpl.accountEntry.get("9973952350").getBalance("9973952350") == 400))
			t = "true";

		assertEquals("false", t);
	}

	@Test
	public void testTransfer3() {
		String t = "false";
		obj.transfer("8295153490", "9973952350", 200);
		if ((AccountDaoImpl.accountEntry.get("8295153490").getBalance("8295153490") != 300)
				&& (AccountDaoImpl.accountEntry.get("9973952350").getBalance("9973952350") != 400))
			t = "true";

		assertEquals("false", t);
	}

}


//
//package com.cg.pw.test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.Test;
//

