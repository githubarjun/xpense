package com.xpense;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xpense.commons.bo.MakerCheckerFieldsBO;
import com.xpense.commons.bo.MasterFieldsBO;
import com.xpense.master.bo.UserBO;
import com.xpense.master.bo.UserGroupBO;
import com.xpense.master.bo.UserGroupDtlsBO;
import com.xpense.transaction.bo.UserGroupEventBO;
import com.xpense.transaction.bo.UserTransactionDtlsBO;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//testMasters();
		testTransactions();
	}

	private static void testMasters(){
		
		UserBO bo = new UserBO();
		
		inflate(bo);
		bo.setUserName("arjun");
		bo.setPassword("pass");
		
		UserGroupBO bo2 = new UserGroupBO();
		
		inflate(bo2);
		bo2.setGroupCode("myGrp");
		bo2.setGroupName("APSFC");
		bo2.setNoOfUsers(5L);
		//bo2.setCreator(bo);
		
		bo.getUserGroups().add(bo2);

		UserGroupDtlsBO bo3 = new UserGroupDtlsBO();
		inflate(bo3);
		bo3.setName("Arjun");
		bo3.setUserId(1L);
		
		UserGroupDtlsBO bo4 = new UserGroupDtlsBO();
		inflate(bo4);
		bo4.setName("Balu");
		bo4.setUserId(null);
		
		//bo2.getGroupDtlsBOs().add(bo3);
		//bo2.getGroupDtlsBOs().add(bo4);
		
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(bo);
		
		transaction.commit();
		
		session.close();
	}

	
	private static void testTransactions(){
		UserGroupEventBO bo = new UserGroupEventBO();
		inflate(bo);
		bo.setGroupId(1L);
		bo.setGroupName("APSFC");
		bo.setCreaterId(1L);
		bo.setCreaterName("Arjun");
		bo.setEventCreatedOn(new Date());
		bo.setEventDescription("party at GK");
		bo.setTotalTransactionAmount(1000D);
		
		UserTransactionDtlsBO bo2 = new UserTransactionDtlsBO();
		inflate(bo2);
		//bo2.setUserGroupEvent(bo);
		bo2.setGroupUserId(1L);
		bo2.setPaidAmount(1000D);
		bo2.setContributionAmount(500D);
		bo2.setDifferenceAmount(-500D);
		
		UserTransactionDtlsBO bo3 = new UserTransactionDtlsBO();
		inflate(bo3);
		//bo3.setUserGroupEvent(bo);
		bo3.setGroupUserId(2L);
		bo3.setPaidAmount(0D);
		bo3.setContributionAmount(500D);
		bo3.setDifferenceAmount(-1000D);
		
		bo.getUserTransactionsDtls().add(bo2);
		bo.getUserTransactionsDtls().add(bo3);
		
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(bo);
		
		transaction.commit();
		
		session.close();
		
	}
	
	private static void inflate(MakerCheckerFieldsBO bo){
		
		bo.setLastStatus("create");
		bo.setCreatedBy("syatem");
		bo.setCreatedDate(new Date());
		bo.setModifiedBy(null);
		bo.setModifiedDate(null);
		
		if(bo instanceof MasterFieldsBO){
			MasterFieldsBO bo1 = (MasterFieldsBO)bo;
			bo1.setActive(true);
			bo1.setEnabled(true);
			bo1.setEffectiveFrom(new Date());
			bo1.setEffectiveTill(null);
		}

		
	}
}
