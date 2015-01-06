
class: center, middle

# Tips on staying out of dependency hell

---

# Agenda

1. Dependency Hell!
2. Why should I bother?
3. How you should bother
3. The Code

---

# Dependency Hell

Transitive dependencies will get you!
.right[![Dependency hell](depfind.png)]

--

Sure, it's handy, but when you have many dependencies, especially with a multi-module pom....

---

# Why you should bother

* You *know* what you're dependent upon
 * Transitive dependencies can change on upstream version changes

* Prompts thought about if you should actually pull that dep in
 * Especially for projects that allow 3rd party modules

* With explicit dependencies multi-module poms can build in parallel
 * Faster build times!
 * Keeps good separation of projects!
 * Find dependency cycles!