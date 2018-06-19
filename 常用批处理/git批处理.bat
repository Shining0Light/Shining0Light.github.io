@echo off 
echo 当前目录是：%cd%
echo;
git add --all
echo;
@echo off
git commit -m "修改后通过批处理提交"
echo;
git push origin master
echo;
echo 批处理执行完毕！
echo;

pause