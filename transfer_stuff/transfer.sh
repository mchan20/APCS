#!bin/bash

#AnotherDimension BankAccount
for f in IntegerSequence LetsGetReal MyLinkedList OrderedArrayList OutOfSorts RadixSort RedirectionLab SuperArray TestAPCSRepo TrianglesAgain
do
    cd ~/test
    git clone git@github.com:mchan20/$f.git
    cd "$f"
    mkdir "$f"
    mv * "$f"
    git add "$f/"
    if [ -f README.md ] ; then
        git add README.md       
    fi
    git commit -am "$f Move content to a subfolder"
    git push origin main
    
    cd ~/test/APCS-1
    git remote add temp ~/test/"$f"
    git fetch temp 
    git add -A .
    git stash
    git pull
    git merge temp/main --allow-unrelated-histories -m "merging temp branch"
    git remote rm temp
    git push origin main
    
    cd ~/test
    rm -rf "$f" 
    
    echo "transferred $f" 
done
