class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> frequencyMap = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length + 1];

        for(int n:nums){
            frequencyMap.put(n,frequencyMap.getOrDefault(n,0) + 1);
        }

        for(int key: frequencyMap.keySet()){

            int frequency = frequencyMap.get(key);
            if(bucket[frequency]==null){
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> topK = new ArrayList<>();

        for(int i = bucket.length-1  ; i>=0 && topK.size()<k ; i--){
            if(bucket[i] != null){
                topK.addAll(bucket[i]);
            }

        }

       return topK.stream().mapToInt(i->i).toArray();

        }
    }
