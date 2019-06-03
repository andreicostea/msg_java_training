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
//		PermissionType p1=new PermissionType("aa","desc1");
//		PermissionType p2=new PermissionType("bb","desc2");
//		PermissionType p3=new PermissionType("dd","desc3");
//		PermissionType p4=new PermissionType("cc","desc4");
//
//
//		RoleEntity r1=new RoleEntity("ADM",Arrays.asList(p1,p2));
//		RoleEntity r2=new RoleEntity("PM", Collections.singletonList(p1));
//		RoleEntity r3=new RoleEntity("TM", Collections.singletonList(p2));
//		RoleEntity r4=new RoleEntity("DEV",new ArrayList<>());
//		RoleEntity r5=new RoleEntity("TEST",new ArrayList<>());
//
//		user.setRoles(Arrays.asList(r1,r2,r3,r4,r5));
//		user2.setRoles(Arrays.asList(r4,r2));
//		user=userDao.createUser(user);
//		user2=userDao.createUser(user2);
//
//		List<PermissionType> permissions=permDao.getPermissionByRole(r1);
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

    public String testCreateUser() {
        UserInputDTO user = new UserInputDTO();
        user.setLastName("Pop");
        user.setFirstName("Andrei");
        user.setEmail("axasde@yahoo.com");
        user.setMobileNumber("07893722");

        this.userFacade.createUser(user);
        return "USER CREATED";
    }
}
