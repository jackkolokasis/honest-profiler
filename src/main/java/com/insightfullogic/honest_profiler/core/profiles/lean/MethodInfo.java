package com.insightfullogic.honest_profiler.core.profiles.lean;

import com.insightfullogic.honest_profiler.core.parser.Method;

public class MethodInfo
{
    private final long methodId;
    private final String fileName;
    private final String className;
    private final String methodName;

    private String cachedFqmn;

    public MethodInfo(long methodId, String fileName, String className, String methodName)
    {
        this.methodId = methodId;
        this.fileName = fileName;
        this.className = className;
        this.methodName = methodName;
    }

    public MethodInfo(Method method)
    {
        this.methodId = method.getMethodId();
        this.fileName = method.getFileName();
        this.className = method.getClassName();
        this.methodName = method.getMethodName();
    }

    public long getMethodId()
    {
        return methodId;
    }

    public String getFileName()
    {
        return fileName;
    }

    public String getClassName()
    {
        return className;
    }

    public String getMethodName()
    {
        return methodName;
    }

    public String getFqmn()
    {
        if (cachedFqmn == null)
        {
            StringBuilder result = new StringBuilder(formatClassName(className));
            result.append(".");
            result.append(methodName);
            cachedFqmn = result.toString();
        }
        return cachedFqmn;
    }

    private String formatClassName(String className)
    {
        if (className.isEmpty())
        {
            return className;
        }

        return className.substring(1, className.length() - 1).replace('/', '.');
    }

    @Override
    // Generated by Eclipse
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((className == null) ? 0 : className.hashCode());
        result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
        result = prime * result + (int) (methodId ^ (methodId >>> 32));
        result = prime * result + ((methodName == null) ? 0 : methodName.hashCode());
        return result;
    }

    @Override
    // Generated by Eclipse
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }

        if (obj == null)
        {
            return false;
        }

        if (getClass() != obj.getClass())
        {
            return false;
        }

        MethodInfo other = (MethodInfo) obj;
        if (className == null)
        {
            if (other.className != null)
            {
                return false;
            }
        }
        else if (!className.equals(other.className))
        {
            return false;
        }

        if (fileName == null)
        {
            if (other.fileName != null)
            {
                return false;
            }
        }
        else if (!fileName.equals(other.fileName))
        {
            return false;
        }
        if (methodId != other.methodId)
        {
            return false;
        }

        if (methodName == null)
        {
            if (other.methodName != null)
            {
                return false;
            }
        }
        else if (!methodName.equals(other.methodName))
        {
            return false;
        }

        return true;
    }
}
