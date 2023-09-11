SELECT
    t.id AS ID,
    t.title AS TITLE,
    t.author AS AUTHOR
FROM books as t
WHERE t.id = :ID