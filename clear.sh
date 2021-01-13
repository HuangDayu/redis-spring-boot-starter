#!/bin/bash
git checkout --orphan blog_new
git branch -D main
git checkout --orphan main
git add .
time=$(date "+%Y-%m-%d %H:%M:%S")
git commit -m "正式发布 1.0.0 版本"
git push -f origin main
echo "Clear success!"