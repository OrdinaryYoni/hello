import pygame, random
import numpy as np
from copy import deepcopy
from snake import Snake, SCREEN_SIZE, PIXEL_SIZE
from genome import Genome

N_POPULATION = 50
N_BEST = 5
N_CHILDREN = 5
PROB_MUTATION = 0.4

pygame.init()
pygame.font.init()
s = pygame.display.set_mode((SCREEN_SIZE * PIXEL_SIZE, SCREEN_SIZE * PIXEL_SIZE))
pygame.display.set_caption('Scake')

#generate 1st population
genomes = [Genome() for _ in range(N_POPULATION)]
best_genomes = None

n_gen = 0
while True:
    n_gen += 1

    for i, genome in enumerate(genomes):
        snake = Snake(s, genome=genome)
        fitness, score = snake.run()

        genome.fitness = fitness

        #print('Generation #%s, Genome #%s, Fitness: %s, Score: %s' % (n_gen, i, fitness, score))

    if best_genomes is not None:
        genomes.extend(best_genomes)
    genomes.sort(key=lambda x: x.fitness, reverse=True)

    print('===== Generation #%s\tBest Fitness %s =====' % (n_gen, genomes[0].fitness))
    #print(genomes[0].w1, genomes[0].w2)

    best_genomes = deepcopy(genomes[:N_BEST])

    #crossover
    for i in range(N_CHILDREN):
        new_genome = deepcopy(best_genomes[0])
        a_genome = random.choice(best_genomes)
        b_genome = random.choice(best_genomes)

        cut = random.randint(0, new_genome.w1.shape[1])
        new_genome.w1[i, :cut] = a_genome.w1[i, :cut]
        new_genome.w1[i, cut:] = b_genome.w1[i, cut:]
