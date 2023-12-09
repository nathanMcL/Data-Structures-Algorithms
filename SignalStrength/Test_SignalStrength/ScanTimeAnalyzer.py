# ScanTimeAnalyzer
from SignalStrength.Main_SignalStrength.ESSIDCategorizer import ESSIDCategorizer


class ScanTimeAnalyzer:
    def __init__(self, data):
        self.data = data
        self.categorizer = ESSIDCategorizer(data)

    def analyze_scan_time(self):
        # Categorize ESSIDs
        categorized_essids = self.categorizer.categorize_essids()

        # Focus on Poor and Weak Ranges
        poor_weak_essids = categorized_essids['Poor Range'].union(categorized_essids['Weak Range'])

        # Filter and Print Data
        for row in self.data:
            if row['ESSID'] in poor_weak_essids:
                print(f"ESSID: {row['ESSID']}, Scan Time: {row['Scan Time']}")
