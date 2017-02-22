
start=`date +%s`
./target/run
end=`date +%s`
runtime=$((end-start))

#echo "totally it takes :" $runtime "seconds for 100000 records."
