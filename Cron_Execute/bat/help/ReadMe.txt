1.       修改cron4j_setting.txt，把需要的RPA Task按sample例子设置好，注意不要有中日文字符，确认都是英数字的路径和文件名。

2.       具体运行时间需要参考cron_schedule_patterns.txt，里面有具体说明和例子。

3.       设定好后，右键点击execute_rpa.cmd用管理员权限运行（需要确保有JDK1.6以上），注意不要关闭该窗体。（最好把这个设定为系统登录以后自动运行）

4.       如果以后远程登录RPA服务器，需要先用管理员权限运行cmd.exe, 通过query session查看当前登录用户的session id；

然后执行tscon 3 /dest:console     其中的3就是前面查询到的session id，这样就可以一直保留登录状态。

 

 

 



