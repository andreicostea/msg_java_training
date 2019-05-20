package msg.ejb;

import msg.user.boundary.UserFacade;
import msg.user.entity.dto.UserInputDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class SomeEjb {
	@EJB
	private UserFacade userFacade;

	public SomeEjb() {
	}

	public String hello() {
//		UserEntity user=new UserEntity();
//		UserEntity user2=new UserEntity();
//
//
//		user.setLastName("Pop");
//		user.setFirstName("Andreea");
//		user.setEmail("abc@yahoo.com");
//		user.setMobileNumber("0789372");
//		user.setCounter(0);
//		user.setUsername("abc");
//		user.setPassword("1234");
//
//		user2.setLastName("Paa");
//		user2.setFirstName("Anaaaa");
//		user2.setEmail("abc@yahoo.com");
//		user2.setMobileNumber("0789372");
//		user2.setCounter(0);
//		user2.setUsername("abc");
//		user2.setPassword("1234");
//
//		Permission p1=new Permission("aa","desc1");
//		Permission p2=new Permission("bb","desc2");
//		Permission p3=new Permission("dd","desc3");
//		Permission p4=new Permission("cc","desc4");
//
//
//		Role r1=new Role("ADM",Arrays.asList(p1,p2));
//		Role r2=new Role("PM", Collections.singletonList(p1));
//		Role r3=new Role("TM", Collections.singletonList(p2));
//		Role r4=new Role("DEV",new ArrayList<>());
//		Role r5=new Role("TEST",new ArrayList<>());
//
//		user.setRoles(Arrays.asList(r1,r2,r3,r4,r5));
//		user2.setRoles(Arrays.asList(r4,r2));
//		user=userDao.createUser(user);
//		user2=userDao.createUser(user2);
//
//		List<Permission> permissions=permDao.getPermissionByRole(r1);
//
////		String type1 = permissions.get(0).getType();
////		String type2 = permissions.get(1).getType();
////		System.out.println(type1);
////		System.out.println(type2);
//
//		permDao.createPermission(p3);
//		permDao.createPermission(p4);
//
//		permDao.removePermission(p3);
		return "Hello JPA World!";
	}

	public String testCreateUser(){
		UserInputDTO user = new UserInputDTO();
		user.setLastName("Pop");
		user.setFirstName("Andrei");
		user.setEmail("axasde@yahoo.com");
		user.setMobileNumber("07893722");
		user.setCounter(0);

		this.userFacade.createUser(user);
		return "USER CREATED";
	}
}
