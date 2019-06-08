package design_patterns.factoryDesignPattern;

 enum EmployeeTypeEnum {
	CEO("ceo") {
		@Override
		public Roles getRoles() {
			// TODO Auto-generated method stub
			return new CEORoles();
		}
	}, CTO("cto") {
		@Override
		public Roles getRoles() {
			// TODO Auto-generated method stub
			return new CTORoles();
		}
	}, DEVELOPER("developer") {
		@Override
		public Roles getRoles() {
			// TODO Auto-generated method stub
			return new DeveloperRoles();
		}
	};
	 String type;
	 EmployeeTypeEnum(String type){
		this.type = type;
	}
	public abstract Roles getRoles();
	
}
