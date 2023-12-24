class WiFiStrengthAverageCalculator:
    def __init__(self, categorized_strengths):
        self.categorized_strengths = categorized_strengths

    def calculate_averages(self):
        averages = {}
        for category, rows in self.categorized_strengths.items():
            total_strength = 0
            count = 0
            for row in rows:
                try:
                    strength = int(row['Wi-Fi -dBm'].split('/')[0])
                    total_strength += strength
                    count += 1
                except Exception as e:
                    print(f"Error processing row {row}: {e}")

            averages[category] = total_strength / count if count > 0 else 0

        return averages