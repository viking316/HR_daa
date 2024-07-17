def maximumPeople(p, x, y, r):
    # Number of towns
    n = len(p)
    # Number of clouds
    m = len(y)
    
    # Dictionary to store which towns are covered by which clouds
    town_coverage = {i: [] for i in range(n)}
    
    # Store population in sunny towns initially (without any cloud removal)
    sunny_pop = sum(p)
    
    # Track how many people are under each cloud
    cloud_pop = [0] * m
    
    # Track people that will be left in darkness regardless of cloud removal
    dark_pop = 0
    
    # Calculate coverage
    for i in range(m):
        cloud_start = y[i] - r[i]
        cloud_end = y[i] + r[i]
        for j in range(n):
            if cloud_start <= x[j] <= cloud_end:
                town_coverage[j].append(i)
                cloud_pop[i] += p[j]
    
    # Calculate the initial population in sunny towns
    for j in range(n):
        if town_coverage[j]:
            sunny_pop -= p[j]
            if len(town_coverage[j]) > 1:
                dark_pop += p[j]
    
    # Calculate the best cloud to remove
    max_sunny_after_removal = sunny_pop
    
    for i in range(m):
        potential_sunny = sunny_pop
        for j in range(n):
            if len(town_coverage[j]) == 1 and town_coverage[j][0] == i:
                potential_sunny += p[j]
        
        max_sunny_after_removal = max(max_sunny_after_removal, potential_sunny)
    
    return max_sunny_after_removal

# Sample Input
p = [10, 100]
x = [5, 100]
y = [4]
r = [1]

# Function Call
print(maximumPeople(p, x, y, r))  # Expected Output: 110