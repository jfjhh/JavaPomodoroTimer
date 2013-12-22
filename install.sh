#!/bin/bash
# install.sh


clear
echo "INSTALLING POMODORO TIMER..."
cd ~/Desktop
git clone https://github.com/jfjhh/JavaPomodoroTimer.git
sleep 1
mkdir ~/Library/Application\ Support/Pomodoro\ Timer
ditto -V JavaPomodoroTimer/Pomodoro_Timer.jar ~/Library/Application\ Support/Pomodoro\ Timer
ditto -V Pomodoro\ Timer.app /Applications/
rm -rfv JavaPomodoroTimer
clear
echo "FINISHED INSTALL; EXITING..."
sleep 3
exit

