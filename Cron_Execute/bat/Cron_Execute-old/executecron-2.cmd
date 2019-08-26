net use * /delete /y
net use Z: \\192.168.19.18\temp /user:flowlites "Flow2015"

java -jar D:\RPA\Cron_Execute\executecron.jar D:\RPA\Cron_Execute\cron4j_setting.txt
