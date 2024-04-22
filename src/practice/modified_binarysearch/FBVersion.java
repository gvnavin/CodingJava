package practice.modified_binarysearch;

public class FBVersion {

    public static boolean isBadVersion(int v) { // isBadVersion() is the API function that returns true or false depending upon whether the provided version ID is bad or not
        return false;
    }

    public static int[] firstBadVersion(int n) {

        int beg = 1;
        int end = n;

        int found = -1;
        int cnt = 0;

        while (beg <= end) {
            int mid = beg + (end - beg) / 2;
            boolean badVersion = isBadVersion(mid);
            cnt++;
            if (mid == 1 && badVersion) {
                found = mid;
                break;
            } else if (mid - 1 >= 1 && badVersion && !isBadVersion(mid - 1)) {
                cnt++;
                found = mid;
                break;
            }  else if (mid + 1 <= n && !badVersion && isBadVersion(mid + 1)) {
                cnt++;
                found = mid+1;
                break;
            } else if (badVersion) {
                end = mid - 1;
            } else {
                beg = mid + 1;
            }
        }

        return new int[]{found, cnt};

    }
}
