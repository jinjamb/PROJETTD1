PARTICIPANTS:

    -CELESTE Maxime
    -CARRÉ Matthias
    -CHANTOISEAU Sacha

DESCRIPTION GÉNÉRALE:
informations préalable: 
    - Pour faire fonctionner le projet il faut compiler tous les éléments, par exmple avec javac (javac ChmVersSrc/Game/*.java -d ChmVersDest).
    - Pour une meilleure experience jouer en plein écran.

Nous avons suivi l'énoncé du TD1 et avons implémenté le système de combat en tour par tour afin d'avoir une expérience un peu plus interactive.
Nous avons également choisi de créer un affichage pour les PNJ, lieux, monstres et métiers afin de rendre l'expérience plus immersive pour le joueur.
Nous sommes restés sur un affichage dans le terminal à l'aide de caractères qui créent des formes.
Certaines fonctions (dégats des sorts en général) ont été implantées dans le Main par manque de temps mais elles auraient mérité leur propres méthodes.
ATTENTION : Si certaines variables ou méthodes possèdent des erreurs d'orthographe cela est dû à un membre du groupe dyslexique. Désolé ^^'.

RÉPARTITION DES TÂCHES:

CELESTE Maxime:

    - Mob --> Implémentation de la classe abstraite Monsters qui hérite de Characters et de tous les monstres qui héritent ensuite de Monsters.
    - Npc --> Implémentation de la classe abstraite Npc qui hérite de Characters et de tous les pnj qui héritent ensuite de Npc.
    - Items --> Tous les items.

CARRÉ Matthias:

    - Characters --> Classe Characters.
    - Job --> Implémentation de la classe Job intentionnellement non abstraite.
    - Show --> Permet l'affichage customisé des informations.
    - Illustrations --> Sauf des Npc.

CHANTOISEAU Sacha:

    - Player --> Implémentation de la classe Player qui hérite de Characters.
    - Places --> Gère le déplacement du joueurs et les informations inhérent à chaques lieux.
    - Le Main qui a été complété par la suite (débuggué et détaillé avec l'aide de Maxime et Matthias)
    - Illustration des Npc.