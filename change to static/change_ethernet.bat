@echo off
echo Choose:
echo [A] Set Static IP
echo [B] Set DHCP
echo [C] Set Auto Static IP 192.168.3.100 subnet 255.255.255.0 Default Gateway 192.168.3.1 interface Ethernet
echo.
:choice
SET /P D=[A,B,C]?
for %%? in (A) do if /I "%D%"=="%%?" goto A
for %%? in (B) do if /I "%D%"=="%%?" goto B
for %%? in (C) do if /I "%D%"=="%%?" goto C
goto choice
:A
@echo off
echo "Please enter Static IP Address Information"
echo "Static IP Address:"
set /p IP_Addr=

echo "Subnet Mask:"
set /p Sub_Mask=

echo "Default Gateway:"
set /p D_Gate=

echo "Setting Static IP Information"
netsh interface ip set address "Ethernet" static %IP_Addr% %Sub_Mask% %D_Gate% 1
netsh int ip show config
pause
goto end

:B
@ECHO OFF
ECHO Resetting IP Address and Subnet Mask For DHCP
netsh int ip set address name = "Ethernet" source = dhcp

ipconfig /renew

ECHO Here are the new settings for %computername%:
netsh int ip show config

pause
goto end

:C
@ECHO OFF
ECHO Automatic config IP Address and Subnet Mask For Static


ipconfig /renew

ECHO Here are the new settings for %computername%:
netsh interface ip set address "Ethernet" static 192.168.3.100 255.255.255.0 192.168.3.1 1
netsh int ip show config

pause
goto end

:end
Script END!