# virus_calculator.py


def print_table(pop, weeks, rate, mort):
    # Print initial output
    print(
        f'Viruscalculator will calculate with {pop} persons at start and run for {weeks} weeks with an increase of infections of {round((float(rate) - 1) * 100, 1)}% and a mortality of {round((float(mort)) * 100, 1)}%:')

    # Print header row
    print('Week   Infections   Deaths')

    for week in range(1, weeks + 1):
        # Calculate values
        infected = pop * (rate ** (week - 1))
        dead = infected * mort

        # Print row
        print(f'{round(week)}       {round(infected)}       {round(dead)}')


def parse_input(user_input):
    params = ('pop', 'weeks', 'rate', 'mort')

    # Strip trailing & leading whitespaces and then split between values.
    user_input = user_input.replace(',', '.')
    l = user_input.strip().split()

    # Simple type validation
    try:
        pop = int(l[0])
        weeks = int(l[1])
        rate = 1 + float(l[2]) / 100
        mort = float(l[3]) / 100
        l = (pop, weeks, rate, mort)
    except Exception as e:
        print('\n Invalid input. Please try again. \n')
        main()
        return

    # Zip it and ship it
    return dict(zip(params, l))


def main():
    # Query user for input.
    user_input = input(
        'Please enter the values for the initial infected population, the runtime in weeks and the infection and mortality rate in percent. \n')
    # Try to parse the input.
    d = parse_input(user_input)
    # Call print_table using the kwargs in the dict.
    print_table(**d)
    # That's it.
    return


main()
