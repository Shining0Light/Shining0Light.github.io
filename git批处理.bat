@echo off 
set path=%path%;D:\git\Git\cmd

git add --all
git commit -m "修改后通过批处理提交"
git push origin


pause
