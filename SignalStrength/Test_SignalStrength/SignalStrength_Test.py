# Wi-Fi Signal Strength Data


import csv
import logging
import sys
import traceback

from SignalStrength.Test_SignalStrength.ESSIDCategorizer import ESSIDCategorizer
from SignalStrengthConfig_Test import csv_file_path
# Import the ESSIDAverageCalculator class
from SignalStrength.Test_SignalStrength.ESSIDAverageCalculator import ESSIDAverageCalculator


logger = logging.getLogger(__name__)
ReplayCounter = 1


def load_data(csv_path):
    local_data = []  # Use a local variable instead of global
    with open(csv_path, mode='r') as file:
        csv_reader = csv.DictReader(file)
        for row in csv_reader:
            local_data.append(row)
    return local_data


def print_data(datas):
    for row in datas:
        print(f"{row['ESSID']}, {row['Quality']}, {row['Scan Time']}")


def get_unique_essids(datas):
    return list({row['ESSID'] for row in datas})


def filter_by_essid(datas, essid):
    return [row for row in datas if row['ESSID'] == essid]


class MenuMode:
    def __init__(self) -> None:
        self.user_input = ""
        self.data = load_data(csv_file_path)  # Load data in the constructor

    def user_instructions(self):  # Define this method to show the menu
        self.main_menu()

    def main_menu(self):
        global ReplayCounter
        ReplayCounter += 1

        user_input = (input("""\n
                            \n  Wi-Fi Signal Strength Menu: \
                            \n 1. Enter 1 to view all data. O(n) \
                            \n 2. Enter 2 to View unique ESSIDs. O(1) \
                            \n 3. Enter 3 to Filter by ESSID. O(n) \
                            \n 4. Enter 4 to Categorize ESSIDs. O(n) \
                            \n 5. Enter 5 to Calculate Average Quality. O(k * m * n) \
                            \n 6. Enter 6 Quit.  \
                            \n\n Please type your selection and push enter: """))

        try:
            self.user_input = int(user_input)
            self.run_mode()
        except ValueError:
            print("please enter a number from the list above")
            self.user_input = None

    def run_mode(self):
        try:
            # O(n). This is a linear operation where n is the number of rows in the data.
            # Each row is printed once.
            if self.user_input == 1:
                print_data(self.data)
            # O(n). The operation iterates through all rows once,
            # adding ESSIDs to a set (which has O(1) insertion time)
            elif self.user_input == 2:
                unique_essids = get_unique_essids(self.data)
                print(unique_essids)
            # O(n). It involves scanning through all the rows to find matches.
            elif self.user_input == 3:
                essid = input("Enter ESSID to filter by: ")
                filtered_data = filter_by_essid(self.data, essid)
                print_data(filtered_data)
            # O(n). Each row is examined once, and the operation to categorize
            # an ESSID is constant time.
            elif self.user_input == 4:
                categorizer = ESSIDCategorizer(self.data)
                categorized_essids = categorizer.categorize_essids()
                for range_name, essids in categorized_essids.items():
                    print(f"{range_name} ESSIDs: {essids}")
            #  For each category, it iterates over its ESSIDs and for each ESSID,
            #  it iterates over all data rows.
            #  If k is the number of categories and m is the average number of ESSIDs per category,
            #  the complexity for this part is O(k * m * n).
            elif self.user_input == 5:
                categorizer = ESSIDCategorizer(self.data)
                categorized_essids = categorizer.categorize_essids()
                average_calculator = ESSIDAverageCalculator(self.data, categorized_essids)
                averages = average_calculator.calculate_averages()

                # Check if all values in averages are None
                if all(value is None for value in averages.values()):
                    print("Error: No averages calculated.")
                else:
                    for range_name, average in averages.items():
                        print(f"{range_name} Average Quality: {average}")
            elif self.user_input == 6:
                print("Exiting...")
                sys.exit()  # Exit the program

        except Exception as e:
            print("Error somewhere: ", e)
            traceback.print_exc()

        if ReplayCounter >= 10 or exit is True:
            print("You have reached the max retries for this program, 10. End of program...")
            sys.exit()
        else:
            replay = input("Push enter to run another operation or type 'exit' to quit: ")

            if replay.lower() == "exit":  # replay the program main loop or type exit to quit
                print("End of program...")
                sys.exit()
            else:
                print("Replay counter", ReplayCounter, "out of 10")
                self.user_instructions()  # Changed from inner_main to user_instructions


def main():
    menu = MenuMode()
    global data  # Declare data as a global variable
    data = load_data(csv_file_path)
    menu.user_instructions()


if __name__ == "__main__":
    main()
