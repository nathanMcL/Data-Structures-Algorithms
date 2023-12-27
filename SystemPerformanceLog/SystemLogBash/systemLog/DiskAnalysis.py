# Disk Usage Analysis

class DiskAnalysis:
    def __init__(self, data):
        self.data = data

    def print_current_disk_usage(self):
        current_usage = self.data[-1]['Disk Usage']
        print(f"Current Logged Disk Usage: {current_usage}")

    def find_nearest_change(self):
        current_usage = float(self.data[-1]['Disk Usage'].rstrip('%'))
        closest_diff = float('inf')
        closest_usage = None

        for row in reversed(self.data[:-1]):
            usage = float(row['Disk Usage'].rstrip('%'))
            diff = abs(usage - current_usage)

            if diff < closest_diff:
                closest_diff = diff
                closest_usage = usage

            if diff > 0:  # Stop if a change is found
                break

        if closest_usage is not None:
            deviation = ((closest_usage - current_usage) / current_usage) * 100
            print(f"Nearest changed Disk Usage: {closest_usage}%, Deviation: {deviation: .2f}%")
        else:
            print("No change in Disk Usage was found.")
