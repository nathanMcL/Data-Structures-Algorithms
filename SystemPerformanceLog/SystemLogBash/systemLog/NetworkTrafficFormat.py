class NetworkTrafficFormat:
    def __init__(self, data):
        self.data = data

    @staticmethod
    def convert_readable_format(value):
        value = int(value)
        if value >= 10 ** 9:  # Gigabytes
            return f"{value / 10 ** 9: .2f} GB"
        elif value >= 10 ** 6:  # Megabytes
            return f"{value / 10 ** 6: .2f} MB"
        elif value >= 10 ** 3:  # Kilobytes
            return f"{value / 10 ** 3: .2f} KB"
        else:
            return f"{value} Bytes"

    def print_converted_network_traffic(self):
        print("Net Traffic Rx (Original) | Converted Rx | Net Traffic Tx (Original) | Converted Tx")
        print("-" * 80)  # Print a separator line for clarity
        for row in self.data:
            rx = row.get('Net Traffic Rx', '0')
            tx = row.get('Net Traffic Tx', '0')
            rx_converted = self.convert_readable_format(rx)
            tx_converted = self.convert_readable_format(tx)

            # Using formatted string literals with specified field widths
            print(f"{rx:>20} | {rx_converted:>10} | {tx:>20} | {tx_converted:>10}")

    def calculate_daily_average(self):
        daily_data = {}
        for row in self.data:
            date = row['Date Time'].split()[0]
            rx_bytes = int(row.get('Net Traffic Rx', 0))
            tx_bytes = int(row.get('Net Traffic Tx', 0))

            if date in daily_data:
                daily_data[date]['rx_total'] += rx_bytes
                daily_data[date]['tx_total'] += tx_bytes
                daily_data[date]['count'] += 1
            else:
                daily_data[date] = {'rx_total': rx_bytes, 'tx_total': tx_bytes, 'count': 1}

        for date, totals in daily_data.items():
            avg_rx = totals['rx_total'] / totals['count']
            avg_tx = totals['tx_total'] / totals['count']
            avg_rx_converted = self.convert_readable_format(avg_rx)
            avg_tx_converted = self.convert_readable_format(avg_tx)
            print(f"{date}: Avg Net Traffic Rx: {avg_rx_converted}, Avg Net Traffic Tx: {avg_tx_converted}")

    def prompt_daily_average(self):
        # Print converted network traffic first
        self.print_converted_network_traffic()
        # Prompt the user
        user_response = input("Do you want to view the Network Traffic daily average? (yes/no): ")
        if user_response.lower() == 'yes':
            self.calculate_daily_average()
