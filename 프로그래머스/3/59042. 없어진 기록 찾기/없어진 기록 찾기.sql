-- 코드를 입력하세요
SELECT outs.ANIMAL_ID, outs.NAME
FROM ANIMAL_INS as ins right join ANIMAL_OUTS as outs
ON ins.ANIMAL_ID = outs.ANIMAL_ID
WHERE ins.ANIMAL_ID is null