#!/bin/bash

# Define the output CSV file
output_file="wifi_signal_strength.csv"

# Function to check if CSV file exists and add header if not
initialize_csv() {
    if [ ! -f $output_file ]; then
        echo "ESSID,Quality,Scan Time" > $output_file
    fi
}

# Function to perform Wi-Fi scan and log results in CSV format
scan_and_log_csv() {
    echo "Scanning for Wi-Fi networks and logging signal strength to CSV..."
    sudo iwlist wlan0 scan | grep -E 'ESSID|Quality' | \
    awk 'ORS=NR%2?FS:RS' | \
    sed 's/Quality=//g' | sed 's/ESSID://g' | \
    awk -F'[ "=]+' -v OFS=',' -v date="$(date)" \
    '{print $2, $4, date}' >> $output_file
}

# Initialize CSV file
initialize_csv

# Main loop - scans every 60 seconds
while true; do
    scan_and_log_csv
    sleep 120
done
