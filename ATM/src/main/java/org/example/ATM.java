package org.example;
import java.util.Scanner;
/**
 * @author Zhou
 * @desc 简单ATM机
 * @date 2024/7/31 14:44
 */
public class ATM {
    static Scanner scanner=new Scanner(System.in);
    static int[] name={1,2,3,4,5,6,7,8,9,10};
    static int[] password={111,222,333,444,555,666,777,888,999,100};
    static int[] balance={12000,24000,185000,15000,900,6300,7200,18100,9100,20000};
    static String admin="super_admin";
    static int admin_password=123;
    public static void main(String[] args) {
        System.out.println("************************************************");
        System.out.println("欢迎来到ATM机管理系统");
        while (true) {
            System.out.println("请选择你的身份：1 用户，2 管理员，0 退出系统");
            int identity = scanner.nextInt();
            switch (identity) {
                case 0:
                    System.out.println("已退出系统，欢迎下次使用！");
                    System.exit(0);
                case 1:
                    login();
                    break;
                case 2:
                    loginAdmin();
                    break;
                default:
                    System.out.println("你的身份有误,请重新选择身份，否则我们将报警了！");
            }
        }
    }
    //用户登录
    public static void login(){
        System.out.println("************************************************");
        System.out.println("用户登录界面");
        System.out.print("请输入你的账户： ");
        int l_name=scanner.nextInt();
        boolean empty=true;
        for(int i=0;i<name.length;i++){
            if(l_name==name[i]){
                empty=false;
                while (true){
                    System.out.print("请输入你的密码： ");
                    int l_password=scanner.nextInt();
                    if(l_password==password[i]){
                        System.out.println("恭喜你，登录成功！");
                        userOperation(i);
                    }else{
                        System.out.println("密码错误，请重新输！");
                    }
                }
            }
        }
        if(empty){
            System.out.println("账户不存在，已退出系统！");
            System.exit(0);
        }
    }
    //用户操作界面
    public static void userOperation(int i){
        System.out.println("************************************************");
        while (true){
            System.out.println("请选择你要进行的操作：1 查询余额，2 存，3 取，4 修改密码，0 退出系统");
            int operation=scanner.nextInt();
            switch (operation){
                case 1:
                    System.out.println("你的余额："+balance[i]+"元");
                    break;
                case 2:
                    System.out.print("请输入你要存的金额：");
                    int save=scanner.nextInt();
                    balance[i]+=save;
                    break;
                case 3:
                    System.out.print("请输入你要取的金额：");
                    int cash=scanner.nextInt();
                    balance[i]-=cash;
                    System.out.println("滋滋滋，请拿好你的现金！");
                    break;
                case 4:
                    while (true){
                        System.out.print("请输入你的原密码：");
                        int at_password=scanner.nextInt();
                        if(password[i]==at_password){
                            System.out.print("请输入你要修改的密码：");
                            int update_password=scanner.nextInt();
                            password[i]=update_password;
                            System.out.println("修改成功！请重新登录系统！");
                            login();
                            break;
                        }else{
                            System.out.println("原密码错误！");
                        }
                    }
                    break;
                case 0:
                    System.out.println("已退出系统，欢迎下次使用！");
                    System.exit(0);
            }
        }
    }
    public static void loginAdmin(){
        System.out.println("************************************************");
        System.out.println("管理员登录界面");
        System.out.print("请输入你的管理员账户： ");
        String admin_name=scanner.next();
        boolean empty=true;
        if(admin_name.equals(admin)){
            empty=false;
            while (true){
                System.out.print("请输入你的密码： ");
                int admin_password1=scanner.nextInt();
                if(admin_password1==admin_password){
                    System.out.println("恭喜你，登录成功！");
                    adminOperation();
                }else{
                    System.out.println("密码错误，请重新输！");
                }
            }
        }
        if(empty){
            System.out.println("账户不存在，已退出系统！");
            System.exit(0);
        }
    }
    public static void adminOperation(){
        System.out.println("************************************************");
        while (true) {
            System.out.println("请选择你要进行的操作：1 查询账户，2 最高和最低金额账户,0 退出系统");
            int admin_operation=scanner.nextInt();
            switch (admin_operation){
                case 1:
                    for(int i=0;i<name.length;i++){
                        System.out.println("账号："+name[i]+"  金额："+balance[i]);
                    }
                    break;
                case 2:
                    int max=balance[0], min=balance[0];
                    for(int i=0;i<balance.length;i++){
                        if(max<balance[i]){
                            max=balance[i];
                        }
                        if(min>balance[i]){
                            min=balance[i];
                        }
                    }
                    System.out.println("max="+max+"  min+"+min);
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}
