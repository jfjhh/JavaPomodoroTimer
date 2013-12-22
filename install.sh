#!/bin/bash
# install.sh


clear
echo "INSTALLING POMODORO TIMER..."
git clone https://github.com/jfjhh/JavaPomodoroTimer.git
sleep 1
mkdir ~/Library/Application\ Support/Pomodoro\ Timer
cp -v JavaPomodoroTimer/Pomodoro_Timer.jar ~/Library/Application\ Support/Pomodoro\ Timer
sudo cp -Rv JavaPomodoroTimer/Pomodoro\ Timer.app /Applications/
sleep 1
rm -rfv JavaPomodoroTimer
echo "FINISHED INSTALL; EXITING..."
sleep 3
rm -v install.sh
