
---
Wi-Fi Signal Strength Data Collection
---

Inspiration: Wanting to continue my learning journey by improving my skills from the things I have been learning in my Data Structures and Algorithms course.
This is only a program that analyzes wifi signal strength data.

[![](https://mermaid.ink/img/pako:eNptkU9PwzAMxb-KlRNIm7j3gNStK-xQAeqAQ7uD17ptRJpA_myUdd8db70wCZ8iv5-fleejqExNIhKNMoeqQ-thk5QauOIiIx0ylrcwn9-PNXocYXGTke9M7W4nanHWYHl8dWRhrZ23ofLSaHea9OVl9knTCEnxJukAsVLgO4KE_bZ_oc3BjLCaoKDlVyBY5fk6cddUZ4nN0iKVyvPO3TBRV1Bqgh3hoViip9ZY-fOvVSr37PTIlKqCYhTiPVlsCV4CKumHKzqX3yOsi1ijGtjv2Rh79074ARZ1S24rZqIn26OsOc7jebIU_M-eShHxs6YGg_KlKPWJUQze5IOuRMSJ0UyET86XEomtxV5EDSrHXaqlNzabTnS51OkXxHiNCw?type=png)](https://mermaid.live/edit#pako:eNptkU9PwzAMxb-KlRNIm7j3gNStK-xQAeqAQ7uD17ptRJpA_myUdd8db70wCZ8iv5-fleejqExNIhKNMoeqQ-thk5QauOIiIx0ylrcwn9-PNXocYXGTke9M7W4nanHWYHl8dWRhrZ23ofLSaHea9OVl9knTCEnxJukAsVLgO4KE_bZ_oc3BjLCaoKDlVyBY5fk6cddUZ4nN0iKVyvPO3TBRV1Bqgh3hoViip9ZY-fOvVSr37PTIlKqCYhTiPVlsCV4CKumHKzqX3yOsi1ijGtjv2Rh79074ARZ1S24rZqIn26OsOc7jebIU_M-eShHxs6YGg_KlKPWJUQze5IOuRMSJ0UyET86XEomtxV5EDSrHXaqlNzabTnS51OkXxHiNCw)


How to run our demo on our included data: Work in progress :)

How to run our tests and what they mean

How we built it (your tech stack)
Starting with the bash script SignalStrength.sh (within the resources folder) That bash script is used to collect the Wi-Fi data from a Raspberry Pi 4, Debian GNU/Linux 11 Operating System.
Once the data is collected, (The idea is to ssh into the Raspberry Pi devices and once navigated to the directory, download the csv data to the remote device, things are complicated :)
I used Python 3.12 to interact with and interpret the wifi_signal_strength.csv data.


Challenges we ran into: Where to start... Trying to run the program in gitpod. Trying to sort my modules in github. Trying ssh into a device to download a file. Trying to use crontab -e to schedule a time to collect data. 

Accomplishments that we're proud of: So far everthing

What we learned

What's next for the project next quarter (as an app engineered for the web)
