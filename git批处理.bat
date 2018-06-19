@echo off 
set path=%path%;D:\git\Git\cmd

git pull
echo;
git add --all
echo;
git commit -m "byBat"
echo;
git push origin
echo;

pause
