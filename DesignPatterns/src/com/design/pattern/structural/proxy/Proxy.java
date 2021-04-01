package com.design.pattern.structural.proxy;

public class Proxy {
	
	interface DBExecutor {
		public void performQuery(String query) throws Exception;
	}
	
	class DBExecutorImpl implements DBExecutor {
		@Override
		public void performQuery(String query) {
			System.out.println("Executing the query : " + query);
		}
	}
	
	class DBProxyExecutor implements DBExecutor {

		private String userName;
		
		private DBExecutorImpl dbExecutor;
		
		public DBProxyExecutor(String userName) {
			this.userName = userName;
			this.dbExecutor = new DBExecutorImpl();
		}
		
		private boolean isAdmin() {
			if (this.userName.toLowerCase().equals("admin")) {
				return true;
			}
			return false;
		}
		
		@Override
		public void performQuery(String query) throws Exception {
			if (query.toLowerCase().equals("delete") && !isAdmin()) {
				throw new Exception("You need Admin Rights to perform Delete query");
			}
			dbExecutor.performQuery(query);
			System.out.println(this.userName + " performed the " + query + " query successfully.");
		}
		
		public void setUserName(String userName) {
			this.userName = userName;
		}
		
	}

	public static void main(String[] args) throws Exception {
		Proxy p = new Proxy();
		DBProxyExecutor nonAdmin = p.new DBProxyExecutor("");
		
		try {
			nonAdmin.performQuery("DELETE");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		nonAdmin.setUserName("ADMIN");
		nonAdmin.performQuery("DELETE");

	}

}
