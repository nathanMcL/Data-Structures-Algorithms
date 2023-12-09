class ESSIDAverageCalculator:
    def __init__(self, data, categorized_essids):
        # Initialize the ESSIDAverageCalculator with provided data and categorized ESSIDs.
        self.data = data
        self.categorized_essids = categorized_essids

    def calculate_averages(self):
        # Initialize dictionaries to hold total quality and count for each range.
        total_quality = {'Poor Range': 0, 'Weak Range': 0, 'Fair Range': 0, 'Good Range': 0,
                         'Excellent Range': 0}
        count = {'Poor Range': 0, 'Weak Range': 0, 'Fair Range': 0, 'Good Range': 0, 'Excellent Range': 0}

        # Iterate through each ESSID range.
        for range_name, essids in self.categorized_essids.items():
            for essid in essids:
                # Find the corresponding data row for this ESSID.
                for row in self.data:
                    if row['ESSID'] == essid:
                        try:
                            # Extract and sum up the quality value.
                            quality_parts = row['ESSID'].split('/')
                            if quality_parts[0].isnumeric():
                                quality = int(quality_parts[0])
                                total_quality[range_name] += quality
                                count[range_name] += 1
                        except Exception as e:
                            print(f"Error processing row {row}: {e}")

        # Calculate and return the average quality for each range.
        averages = {}
        for range_name in total_quality:
            if count[range_name] > 0:
                averages[range_name] = total_quality[range_name] / count[range_name]
            else:
                averages[range_name] = None  # No data for this range.

        return averages
