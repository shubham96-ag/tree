package SearchingAlgo;

public class SearchingAlgo {
    public static void main(String[] args) {
        int [] a ={4,4,4,4,5,6};
        int [] a1 ={11,12,15,18,2,5,6,8};
        int [] a2={15,18,2,3,6,12};
        int [] nearlySorted={5,10,30,20,40};
        System.out.println("First occurence of 4 is at index: "+findFirstOccurence(a,4));
        System.out.println("Last occurence of 4 is at index: "+findLastOccurence(a,4));
        System.out.println("Total number of 4 in array are:"+(findLastOccurence(a,4)-findFirstOccurence(a,4)+1));
        System.out.println("Number of times sorted array is rotated: "+noOfTimesSortedArrayIsRotated(a1));
        System.out.println("Findnd: "+findMinIdx(a1));
        System.out.println("Index of 6 in rotated sorted array  is:  "+findElementInRotatedSortedArray(a2,6));
        System.out.println("index of 20 in nearlt sorted array is : "+findElementInNearlySortedArray(nearlySorted,20));
    }

    public static int binarySearch(int[] a,int start,int end, int key){
        //int start = 0;
        //int end = a.length-1;
        while (start<=end){
            int mid = start + (end-start)/2;
            if(a[mid]==key)
                return mid;
            else if(a[mid]<key)
                start=mid+1;
            else
                end=mid-1;
        }
        return -1;
    }
    //this function gives the first occurence oe thr given element in array
    public static int findFirstOccurence(int[] a, int key){
        int start = 0, end=a.length-1,mid,res=-1;
        while (start<=end){
            mid = start + (end-start)/2;
            if(a[mid]==key){
                res=mid;
                end=mid-1;
            }
            else if(a[mid]>key)
                end = mid -1;
            else
                start = mid + 1;
        }
        return res;
    }

    public static int findLastOccurence(int[] a, int key){
        int start = 0, end=a.length-1,mid,res=-1;
        while (start<=end){
            mid = start + (end-start)/2;
            if(a[mid]==key){
                res=mid;
                start=mid+1;
            }
            else if(a[mid]>key)
                end = mid -1;
            else
                start = mid + 1;
        }
        return res;
    }

    //{11,12,15,18,2,5,6,8}
    //noOfTimesSortedArrayIsRotated(int [] a)  this is equal to the index of the minimum element
    public static int noOfTimesSortedArrayIsRotated(int[] a ){
        int start=0, end=a.length-1,mid=0,n=a.length;
        while(start<=end){
            mid=start+(end-start)/2;
            int prev = (mid+n-1)%n;
            int next = (mid+1)%n;
            if(a[mid]<=a[prev] && a[mid]<=a[next])   //the smallest element will be smaller than left and right element
                return mid;                        //index of mid will be the number of times array is rotated
           else if(a[start]<=a[mid])   //atart    1  mid   2     end
                start=mid+1;       //means subarray 1 is sorted hence answer will be in right subarray
            else if(a[mid]<=a[end])
                end=mid-1;         //means the right subarray is sorted hence doing end=mid-1 will make search in left subarray
        }
        return 0;
    }

    //this method will return the index of min element. Not recommende use the above one to do so
    public static int findMinIdx(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end])
                start = mid + 1;
            else
                end = mid;
        }
        return start;
    }

    public static int findElementInRotatedSortedArray(int[] a,int key){
        int indexOfSmallestElement = noOfTimesSortedArrayIsRotated(a);
        int res1=binarySearch(a,indexOfSmallestElement,a.length-1,key);
        int res2=binarySearch(a,0,indexOfSmallestElement-1,key);
        if(res1!=-1)
            return res1;
        return res2;
    }

    //nearly sorted array means that ith element can be present in (i-1)th (i)th (i+1)th position
    public static int findElementInNearlySortedArray(int [] a, int key){
        int start = 0,end = a.length-1,mid;
        while(start<end){
            mid = (start+end)/2;
            if(a[mid]==key)
                return mid;
            if(a[mid-1]==key && (mid-1)>start)
                return mid-1;
            if(a[mid+1]==key && (mid+1)<end)
                return mid+1;
            if(a[mid]>key)
                end=mid-2;
            if(a[mid]<key)
                start=mid+2;
        }
        return -1;
    }


}
