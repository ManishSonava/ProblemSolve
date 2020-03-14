# tSystem:
This repository is for crawling the url for a specified depth. 

1. Code is implemented as per the requirement.

2. MongoDB is used as a persistent store.

3. Failure retry is not included but it can be done with an inclusion of a failed attemtp's in crawl response collection and a   config which will decide till how many attempts we can allow. this will be taken care by scheduler.

4. Rest end points are created as per the requirement

5. A scheduler is created to pick the submitted, failed jobs and perform the required action on them.

6. Code is documented.


# Note: 
We can discuss if anything is missing there.

