# smplIgnitePrj4T

Программа описывает простой пример создания серверной ноды для apache Ignite, внутри контейнера tomcat под Spring boot. 
В данном случае обращение реализовано по рест(по хорошему нужно делать post, но get можно подцепить из браузера).
Для хранения используется кэш ignite. При перезапуске он забудет все значения.

Методы получения и присвоения ключа синхронизированы. 

